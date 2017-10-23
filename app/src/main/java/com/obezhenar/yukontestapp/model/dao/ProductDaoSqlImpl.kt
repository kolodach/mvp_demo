package com.obezhenar.yukontestapp.model.dao

import android.database.sqlite.SQLiteDatabase
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

    override fun getProductsInStore(storeId: Long, page: Int) = observable {
        database.rawQuery("SELECT * FROM ${ProductContract.TABLE_NAME} " +
                "WHERE ${ProductContract.ID} NOT IN " +
                "(SELECT ${InventoryContract.STORE_ID} " +
                "FROM ${InventoryContract.TABLE_NAME} " +
                "OFFSET ${C.RECORDS_PER_PAGE * (page - 1)} " +
                "LIMIT ${C.RECORDS_PER_PAGE});", null)
    }.map { it.obtainProducts() }
            .doOnError { it.printStackTrace() }
            .onErrorResumeNext(observable { emptyList<Product>() })

    override fun getProductById(productId: Long) = observable {
        database.rawQuery("SELECT * FROM ${ProductContract.TABLE_NAME} WHERE " +
                "${ProductContract.ID}=$productId;", null)
    }.map { it.obtainProducts()[0] }

    override fun insertAll(products: List<Product>) = completable {
        products.map { it.obtainContentValues() }
                .forEach { database.insert(ProductContract.TABLE_NAME, null, it) }
    }

    override fun removeAll() = completable {
        database.execSQL("DROP TABLE ${ProductContract.TABLE_NAME};")
        ProductContract.createTable(database)
    }
}