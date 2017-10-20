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
package com.obezhenar.yukontestapp.model.dao.sql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.obezhenar.yukontestapp.model.dao.sql.contract.InventoryContract
import com.obezhenar.yukontestapp.model.dao.sql.contract.ProductContract
import com.obezhenar.yukontestapp.model.dao.sql.contract.StoreContract

/**
 * Created by 1 on 10/19/2017.
 */
class AppDbHelper(private val context: Context)
    : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "LCBO.db"
    }

    override fun onCreate(db: SQLiteDatabase) {
        StoreContract.createTable(db)
        ProductContract.createTable(db)
        InventoryContract.createTable(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        StoreContract.upgradeTable(db, oldVersion, newVersion)
        ProductContract.upgradeTable(db, oldVersion, newVersion)
        InventoryContract.upgradeTable(db, oldVersion, newVersion)
    }
}