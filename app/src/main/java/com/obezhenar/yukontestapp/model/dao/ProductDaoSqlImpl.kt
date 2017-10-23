/**
 * Copyright © 2017 Oleg Bezhenar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http:
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.obezhenar.yukontestapp.model.dao

import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.obezhenar.yukontestapp.C
import com.obezhenar.yukontestapp.common.extensions.completable
import com.obezhenar.yukontestapp.common.extensions.observable
import com.obezhenar.yukontestapp.model.dao.sql.contract.*
import com.obezhenar.yukontestapp.model.entity.Product
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * Created by kolod on 23.10.2017.
 */
class ProductDaoSqlImpl(private val database: SQLiteDatabase) : ProductDao {
    val TAG = "ProductDaoSqlImpl"

    override fun getProductsInStore(storeId: Long, page: Int) = observable {
        database.rawQuery("SELECT * FROM ${ProductContract.TABLE_NAME} " +
                "LIMIT ${C.RECORDS_PER_PAGE} " +
                "OFFSET ${C.RECORDS_PER_PAGE * (page - 1)};", null)
    }.map { it.obtainProducts() }
            .doOnNext { Log.d(TAG, it.toString()) }
            .doOnError { it.printStackTrace() }
            .onErrorResumeNext(observable { emptyList<Product>() })

    override fun getProductById(productId: Long) = observable {
        database.rawQuery("SELECT * FROM ${ProductContract.TABLE_NAME} WHERE " +
                "${ProductContract.ID}=$productId;", null)
    }.map { it.obtainProducts()[0] }

    override fun insertAll(products: List<Product>) = completable {
        products.map { it.obtainContentValues() }
                .forEach {
                    database.insertWithOnConflict(ProductContract.TABLE_NAME, null,
                            it, SQLiteDatabase.CONFLICT_REPLACE)
                }
    }

    override fun removeAll() = completable {
        database.execSQL("DROP TABLE ${ProductContract.TABLE_NAME};")
        database.execSQL("DROP TABLE ${InventoryContract.TABLE_NAME};")
        ProductContract.createTable(database)
        InventoryContract.createTable(database)
    }
}