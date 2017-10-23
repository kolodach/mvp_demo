package com.obezhenar.yukontestapp.model.dao

import android.database.sqlite.SQLiteDatabase
import com.obezhenar.yukontestapp.C
import com.obezhenar.yukontestapp.common.extensions.completable
import com.obezhenar.yukontestapp.common.extensions.observable
import com.obezhenar.yukontestapp.model.dao.sql.contract.InventoryContract
import com.obezhenar.yukontestapp.model.dao.sql.contract.StoreContract
import com.obezhenar.yukontestapp.model.dao.sql.contract.obtainContentValues
import com.obezhenar.yukontestapp.model.dao.sql.contract.obtainInventories
import com.obezhenar.yukontestapp.model.entity.Inventory
import com.obezhenar.yukontestapp.model.entity.Store
import io.reactivex.Observable

/**
 * Sqlite implementation of Inventory dao
 */
class InventoryDaoSqlImpl(private val database: SQLiteDatabase) : InventoryDao {
    override fun getInventoriesByStoreId(storeId: Long, page: Int) = observable {
        database.rawQuery("SELECT * FROM ${InventoryContract.TABLE_NAME} " +
                "WHERE ${InventoryContract.STORE_ID}=$storeId " +
                "LIMIT ${C.RECORDS_PER_PAGE} " +
                "OFFSET ${C.RECORDS_PER_PAGE * (page - 1)};", null)
    }.map { it.obtainInventories() }
            .doOnError { it.printStackTrace() }
            .onErrorResumeNext(observable { emptyList<Inventory>() })

    override fun insertAll(inventories: List<Inventory>) = completable {
        inventories.map { it.obtainContentValues() }
                .forEach { database.insert(InventoryContract.TABLE_NAME, null, it) }
    }

    override fun removeAll() = completable {
        database.execSQL("DROP TABLE ${InventoryContract.TABLE_NAME};")
        InventoryContract.createTable(database)
    }
}