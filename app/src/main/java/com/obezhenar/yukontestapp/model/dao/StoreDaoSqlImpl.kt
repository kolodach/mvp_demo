/**
 * Copyright © 2017 Oleg Bezhenar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.obezhenar.yukontestapp.model.dao

import android.database.sqlite.SQLiteDatabase
import com.obezhenar.yukontestapp.C
import com.obezhenar.yukontestapp.common.extensions.completable
import com.obezhenar.yukontestapp.common.extensions.observable
import com.obezhenar.yukontestapp.model.dao.sql.contract.StoreContract
import com.obezhenar.yukontestapp.model.entity.Store
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by 1 on 10/20/2017.
 */
class StoreDaoSqlImpl(private val database: SQLiteDatabase) : StoreDao {
    override fun getStoresByPage(page: Int): Observable<List<Store>> =
            observable {
                database.rawQuery("SELECT * FROM ${StoreContract.TABLE_NAME} LIMIT ${C.RECORDS_PER_PAGE} " +
                        "OFFSET ${C.RECORDS_PER_PAGE * (page - 1)};", null)
            }
                    .map { StoreContract.obtainStores(it) }
                    .doOnError { it.printStackTrace() }
                    .onErrorResumeNext(observable { emptyList<Store>() })

    override fun getStoreById(id: Long): Single<Store> =
            observable {
                database.rawQuery("SELECT * FROM ${StoreContract.TABLE_NAME} WHERE " +
                        "${StoreContract.ID}=$id;", null)
            }.map { StoreContract.obtainStores(it)[0] }
                    .singleOrError()

    override fun insertAll(stores: List<Store>) = completable {
        stores.map { StoreContract.obtainContentValues(it) }
                .forEach { database.insert(StoreContract.TABLE_NAME, null, it) }
    }

    override fun removeAll(): Completable = completable {
        database.execSQL("DROP TABLE ${StoreContract.TABLE_NAME};")
        StoreContract.createTable(database)
    }
}