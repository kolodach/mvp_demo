package com.obezhenar.yukontestapp.model.dao

import com.obezhenar.yukontestapp.model.entity.Inventory
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * Inventory data access object
 */
interface InventoryDao {
    fun getInventoriesByStoreId(storeId: Long, page: Int): Observable<List<Inventory>>

    fun insertAll(inventories: List<Inventory>): Completable

    fun removeAll(): Completable
}