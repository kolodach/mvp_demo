/**
 * Copyright © 2017 Oleg Bezhenar
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.obezhenar.yukontestapp.common.di

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.obezhenar.yukontestapp.model.dao.*
import com.obezhenar.yukontestapp.model.dao.sql.AppDbHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Dagger 2 module.Provides DAO interfaces implementations.
 */
@Module
class DaoModule {
    @Provides
    @Singleton
    fun provideUserDao(context: Context): UserDao = UserDaoAuthenticatorImpl(context)

    @Provides
    @Singleton
    fun provideStoreDao(database: SQLiteDatabase): StoreDao = StoreDaoSqlImpl(database)

    @Provides
    @Singleton
    fun provideProductDa(database: SQLiteDatabase): ProductDao = ProductDaoSqlImpl(database)

    @Provides
    @Singleton
    fun provideInventoryDao(database: SQLiteDatabase): InventoryDao = InventoryDaoSqlImpl(database)

    @Provides
    @Singleton
    fun provideDatabase(context: Context): SQLiteDatabase {
        val dbHelper = AppDbHelper(context)
        return dbHelper.writableDatabase
    }
}
