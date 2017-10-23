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