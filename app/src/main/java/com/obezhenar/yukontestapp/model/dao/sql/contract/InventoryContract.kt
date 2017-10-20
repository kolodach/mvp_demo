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
package com.obezhenar.yukontestapp.model.dao.sql.contract

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.obezhenar.yukontestapp.model.entity.Inventory

/**
 * Created by 1 on 10/19/2017.
 */
class InventoryContract {
    companion object : BaseContract() {
        val TABLE_NAME = "inventory"

        val PRODUCT_ID = "product_id"
        val STORE_ID = "store_id"
        val IS_DEAD = "is_dead"
        val QUANTITY = "quantity"
        val UPDATED_ON = "updated_on"
        val UPDATED_AT = "updated_at"
        val PRODUCT_NO = "product_no"
        val STORE_NO = "store_no"


        fun createTable(db: SQLiteDatabase) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                    ID + " INTEGER PRIMARY KEY," +
                    PRODUCT_ID + TYPE_TEXT + COMMA_SEP +
                    STORE_ID + TYPE_TEXT + COMMA_SEP +
                    IS_DEAD + TYPE_TEXT + COMMA_SEP +
                    QUANTITY + TYPE_TEXT + COMMA_SEP +
                    UPDATED_ON + TYPE_TEXT + COMMA_SEP +
                    UPDATED_AT + TYPE_TEXT + COMMA_SEP +
                    PRODUCT_NO + TYPE_TEXT + COMMA_SEP +
                    STORE_NO + TYPE_TEXT +
                    " )")
        }

        fun upgradeTable(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        }

        fun Inventory.obtainContentValues(): ContentValues {
            val cv = ContentValues()
            cv.put(PRODUCT_ID, productId)
            cv.put(STORE_ID, storeId)
            cv.put(IS_DEAD, isDead)
            cv.put(QUANTITY, quantity)
            cv.put(UPDATED_ON, updatedOn)
            cv.put(UPDATED_AT, updatedAt)
            cv.put(PRODUCT_NO, productNo)
            cv.put(STORE_NO, storeNo)
            return cv
        }

        fun Cursor.obtainInventories(): List<Inventory> {
            val inventories = ArrayList<Inventory>()
            if (moveToFirst())
                do {
                    inventories.add(Inventory(
                            getString(getColumnIndex(PRODUCT_ID)).toLong(),
                            getString(getColumnIndex(STORE_ID)).toLong(),
                            getString(getColumnIndex(IS_DEAD)).toBoolean(),
                            getString(getColumnIndex(QUANTITY)).toInt(),
                            getString(getColumnIndex(UPDATED_ON)),
                            getString(getColumnIndex(UPDATED_AT)),
                            getString(getColumnIndex(PRODUCT_NO)).toLong(),
                            getString(getColumnIndex(STORE_NO)).toInt()
                    ))
                } while (moveToNext())
            close()
            return inventories
        }

    }
}