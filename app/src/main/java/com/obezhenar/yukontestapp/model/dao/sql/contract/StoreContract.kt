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
package com.obezhenar.yukontestapp.model.dao.sql.contract

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.obezhenar.yukontestapp.model.entity.Store

/**
 *
 */
class StoreContract {
    companion object : BaseContract(){
        val TABLE_NAME = "store"

        val IS_DEAD = "is_dead"
        val NAME = "name"
        val TAGS = "tags"
        val ADDRESS_LINE_1 = "address_line_1"
        val ADDRESS_LINE_2 = "address_line_2"
        val CITY = "city"
        val POSTAL_CODE = "postal_code"
        val TELEPHONE = "telephone"
        val FAX = "fax"
        val LATITUDE = "latitude"
        val LONGITUDE = "longitude"
        val PRODUCTS_COUNT = "products_count"
        val INVENTORY_COUNT = "inventory_count"
        val INVENTORY_PRICE_IN_CENTS = "inventory_price_in_cents"
        val INVENTORY_VOLUME_IN_MILLILITERS = "inventory_volume_in_milliliters"
        val HAS_WHEELCHAIR_ACCESSABILITY = "has_wheelchair_accessability"
        val HAS_BILINGUAL_SERVICES = "has_bilingual_services"
        val HAS_PRODUCT_CONSULTANT = "has_product_consultant"
        val HAS_TASTING_BAR = "has_tasting_bar"
        val HAS_BEER_COLD_ROOM = "has_beer_cold_room"
        val HAS_SPECIAL_OCCASION_PERMITS = "has_special_occasion_permits"
        val HAS_VINTAGES_CORNER = "has_vintages_corner"
        val HAS_PARKING = "has_parking"
        val HAS_TRANSIT_ACCESS = "has_transit_access"
        val SUNDAY_OPEN = "sunday_open"
        val SUNDAY_CLOSE = "sunday_close"
        val MONDAY_OPEN = "monday_open"
        val MONDAY_CLOSE = "monday_close"
        val TUESDAY_OPEN = "tuesday_open"
        val TUESDAY_CLOSE = "tuesday_close"
        val WEDNESDAY_OPEN = "wednesday_open"
        val WEDNESDAY_CLOSE = "wednesday_close"
        val THURSDAY_OPEN = "thursday_open"
        val THURSDAY_CLOSE = "thursday_close"
        val FRIDAY_OPEN = "friday_open"
        val FRIDAY_CLOSE = "friday_close"
        val SATURDAY_OPEN = "saturday_open"
        val SATURDAY_CLOSE = "saturday_close"
        val UPDATED_AT = "updated_at"
        val STORE_NO = "store_no"

        fun createTable(db: SQLiteDatabase) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                    ID + " INTEGER PRIMARY KEY," +
                    IS_DEAD + TYPE_TEXT + COMMA_SEP +
                    NAME + TYPE_TEXT + COMMA_SEP +
                    TAGS + TYPE_TEXT + COMMA_SEP +
                    ADDRESS_LINE_1 + TYPE_TEXT + COMMA_SEP +
                    ADDRESS_LINE_2 + TYPE_TEXT + COMMA_SEP +
                    CITY + TYPE_TEXT + COMMA_SEP +
                    POSTAL_CODE + TYPE_TEXT + COMMA_SEP +
                    TELEPHONE + TYPE_TEXT + COMMA_SEP +
                    FAX + TYPE_TEXT + COMMA_SEP +
                    LATITUDE + TYPE_TEXT + COMMA_SEP +
                    LONGITUDE + TYPE_TEXT + COMMA_SEP +
                    PRODUCTS_COUNT + TYPE_TEXT + COMMA_SEP +
                    INVENTORY_COUNT + TYPE_TEXT + COMMA_SEP +
                    INVENTORY_PRICE_IN_CENTS + TYPE_TEXT + COMMA_SEP +
                    INVENTORY_VOLUME_IN_MILLILITERS + TYPE_TEXT + COMMA_SEP +
                    HAS_WHEELCHAIR_ACCESSABILITY + TYPE_TEXT + COMMA_SEP +
                    HAS_BILINGUAL_SERVICES + TYPE_TEXT + COMMA_SEP +
                    HAS_PRODUCT_CONSULTANT + TYPE_TEXT + COMMA_SEP +
                    HAS_TASTING_BAR + TYPE_TEXT + COMMA_SEP +
                    HAS_BEER_COLD_ROOM + TYPE_TEXT + COMMA_SEP +
                    HAS_SPECIAL_OCCASION_PERMITS + TYPE_TEXT + COMMA_SEP +
                    HAS_VINTAGES_CORNER + TYPE_TEXT + COMMA_SEP +
                    HAS_PARKING + TYPE_TEXT + COMMA_SEP +
                    HAS_TRANSIT_ACCESS + TYPE_TEXT + COMMA_SEP +
                    SUNDAY_OPEN + TYPE_TEXT + COMMA_SEP +
                    SUNDAY_CLOSE + TYPE_TEXT + COMMA_SEP +
                    MONDAY_OPEN + TYPE_TEXT + COMMA_SEP +
                    MONDAY_CLOSE + TYPE_TEXT + COMMA_SEP +
                    TUESDAY_OPEN + TYPE_TEXT + COMMA_SEP +
                    TUESDAY_CLOSE + TYPE_TEXT + COMMA_SEP +
                    WEDNESDAY_OPEN + TYPE_TEXT + COMMA_SEP +
                    WEDNESDAY_CLOSE + TYPE_TEXT + COMMA_SEP +
                    THURSDAY_OPEN + TYPE_TEXT + COMMA_SEP +
                    THURSDAY_CLOSE + TYPE_TEXT + COMMA_SEP +
                    FRIDAY_OPEN + TYPE_TEXT + COMMA_SEP +
                    FRIDAY_CLOSE + TYPE_TEXT + COMMA_SEP +
                    SATURDAY_OPEN + TYPE_TEXT + COMMA_SEP +
                    SATURDAY_CLOSE + TYPE_TEXT + COMMA_SEP +
                    UPDATED_AT + TYPE_TEXT + COMMA_SEP +
                    STORE_NO + TYPE_TEXT + " )")
        }

        fun upgradeTable(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        }

        fun obtainContentValues(store : Store): ContentValues {
            val cv = ContentValues()
            cv.put(IS_DEAD, store.isDead)
            cv.put(NAME, store.name)
            cv.put(TAGS, store.tags)
            cv.put(ADDRESS_LINE_1, store.addressLine1)
            cv.put(ADDRESS_LINE_2, store.addressLine2)
            cv.put(CITY, store.city)
            cv.put(POSTAL_CODE, store.postalCode)
            cv.put(TELEPHONE, store.telephone)
            cv.put(FAX, store.fax)
            cv.put(LATITUDE, store.latitude)
            cv.put(LONGITUDE, store.longitude)
            cv.put(PRODUCTS_COUNT, store.productsCount)
            cv.put(INVENTORY_COUNT, store.inventoryCount)
            cv.put(INVENTORY_PRICE_IN_CENTS, store.inventoryPriceInCents)
            cv.put(INVENTORY_VOLUME_IN_MILLILITERS, store.inventoryVolumeInMilliliters)
            cv.put(HAS_WHEELCHAIR_ACCESSABILITY, store.hasWheelchairAccessability)
            cv.put(HAS_BILINGUAL_SERVICES, store.hasBilingualServices)
            cv.put(HAS_PRODUCT_CONSULTANT, store.hasProductConsultant)
            cv.put(HAS_TASTING_BAR, store.hasTastingBar)
            cv.put(HAS_BEER_COLD_ROOM, store.hasBeerColdRoom)
            cv.put(HAS_SPECIAL_OCCASION_PERMITS, store.hasSpecialOccasionPermits)
            cv.put(HAS_VINTAGES_CORNER, store.hasVintagesCorner)
            cv.put(HAS_PARKING, store.hasParking)
            cv.put(HAS_TRANSIT_ACCESS, store.hasTransitAccess)
            cv.put(SUNDAY_OPEN, store.sundayOpen)
            cv.put(SUNDAY_CLOSE, store.sundayClose)
            cv.put(MONDAY_OPEN, store.mondayOpen)
            cv.put(MONDAY_CLOSE, store.mondayClose)
            cv.put(TUESDAY_OPEN, store.tuesdayOpen)
            cv.put(TUESDAY_CLOSE, store.tuesdayClose)
            cv.put(WEDNESDAY_OPEN, store.wednesdayOpen)
            cv.put(WEDNESDAY_CLOSE, store.wednesdayClose)
            cv.put(THURSDAY_OPEN, store.thursdayOpen)
            cv.put(THURSDAY_CLOSE, store.thursdayClose)
            cv.put(FRIDAY_OPEN, store.fridayOpen)
            cv.put(FRIDAY_CLOSE, store.fridayClose)
            cv.put(SATURDAY_OPEN, store.saturdayOpen)
            cv.put(SATURDAY_CLOSE, store.saturdayClose)
            cv.put(UPDATED_AT, store.updatedAt)
            cv.put(STORE_NO, store.storeNo)
            return cv
        }

        fun obtainStores(cursor: Cursor): List<Store> {
            val stores = ArrayList<Store>()
            if (cursor.moveToFirst())
                do {
                    stores.add(Store(
                            cursor.getInt(cursor.getColumnIndex(ID)),
                            cursor.getString(cursor.getColumnIndex(IS_DEAD)).toBoolean(),
                            cursor.getString(cursor.getColumnIndex(NAME)),
                            cursor.getString(cursor.getColumnIndex(TAGS)),
                            cursor.getString(cursor.getColumnIndex(ADDRESS_LINE_1)),
                            cursor.getString(cursor.getColumnIndex(ADDRESS_LINE_2)),
                            cursor.getString(cursor.getColumnIndex(CITY)),
                            cursor.getString(cursor.getColumnIndex(POSTAL_CODE)),
                            cursor.getString(cursor.getColumnIndex(TELEPHONE)),
                            cursor.getString(cursor.getColumnIndex(FAX)),
                            cursor.getString(cursor.getColumnIndex(LATITUDE)).toDouble(),
                            cursor.getString(cursor.getColumnIndex(LONGITUDE)).toDouble(),
                            cursor.getString(cursor.getColumnIndex(PRODUCTS_COUNT)).toInt(),
                            cursor.getString(cursor.getColumnIndex(INVENTORY_COUNT)).toInt(),
                            cursor.getString(cursor.getColumnIndex(INVENTORY_PRICE_IN_CENTS)).toInt(),
                            cursor.getString(cursor.getColumnIndex(INVENTORY_VOLUME_IN_MILLILITERS)).toInt(),
                            cursor.getString(cursor.getColumnIndex(HAS_WHEELCHAIR_ACCESSABILITY)).toBoolean(),
                            cursor.getString(cursor.getColumnIndex(HAS_BILINGUAL_SERVICES)).toBoolean(),
                            cursor.getString(cursor.getColumnIndex(HAS_PRODUCT_CONSULTANT)).toBoolean(),
                            cursor.getString(cursor.getColumnIndex(HAS_TASTING_BAR)).toBoolean(),
                            cursor.getString(cursor.getColumnIndex(HAS_BEER_COLD_ROOM)).toBoolean(),
                            cursor.getString(cursor.getColumnIndex(HAS_SPECIAL_OCCASION_PERMITS)).toBoolean(),
                            cursor.getString(cursor.getColumnIndex(HAS_VINTAGES_CORNER)).toBoolean(),
                            cursor.getString(cursor.getColumnIndex(HAS_PARKING)).toBoolean(),
                            cursor.getString(cursor.getColumnIndex(HAS_TRANSIT_ACCESS)).toBoolean(),
                            cursor.getString(cursor.getColumnIndex(SUNDAY_OPEN)).toInt(),
                            cursor.getString(cursor.getColumnIndex(SUNDAY_CLOSE)).toInt(),
                            cursor.getString(cursor.getColumnIndex(MONDAY_OPEN)).toInt(),
                            cursor.getString(cursor.getColumnIndex(MONDAY_CLOSE)).toInt(),
                            cursor.getString(cursor.getColumnIndex(TUESDAY_OPEN)).toInt(),
                            cursor.getString(cursor.getColumnIndex(TUESDAY_CLOSE)).toInt(),
                            cursor.getString(cursor.getColumnIndex(WEDNESDAY_OPEN)).toInt(),
                            cursor.getString(cursor.getColumnIndex(WEDNESDAY_CLOSE)).toInt(),
                            cursor.getString(cursor.getColumnIndex(THURSDAY_OPEN)).toInt(),
                            cursor.getString(cursor.getColumnIndex(THURSDAY_CLOSE)).toInt(),
                            cursor.getString(cursor.getColumnIndex(FRIDAY_OPEN)).toInt(),
                            cursor.getString(cursor.getColumnIndex(FRIDAY_CLOSE)).toInt(),
                            cursor.getString(cursor.getColumnIndex(SATURDAY_OPEN)).toInt(),
                            cursor.getString(cursor.getColumnIndex(SATURDAY_CLOSE)).toInt(),
                            cursor.getString(cursor.getColumnIndex(UPDATED_AT)).toString(),
                            cursor.getString(cursor.getColumnIndex(STORE_NO)).toInt())
                    )
                } while (cursor.moveToNext())
            cursor.close()
            return stores
        }
    }
}
