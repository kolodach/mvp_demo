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
import com.obezhenar.yukontestapp.model.entity.Product

/**
 * Created by 1 on 10/19/2017.
 */
class ProductContract {
    companion object : BaseContract() {
        val TABLE_NAME = "product"

        val IS_DEAD = "is_dead"
        val NAME = "name"
        val TAGS = "tags"
        val IS_DISCONTINUED = "is_discontinued"
        val PRICE_IN_CENTS = "price_in_cents"
        val REGULAR_PRICE_IN_CENTS = "regular_price_in_cents"
        val LIMITED_TIME_OFFER_SAVINGS_IN_CENTS = "limited_time_offer_savings_in_cents"
        val LIMITED_TIME_OFFER_ENDS_ON = "limited_time_offer_ends_on"
        val BONUS_REWARD_MILES = "bonus_reward_miles"
        val BONUS_REWARD_MILES_ENDS_ON = "bonus_reward_miles_ends_on"
        val STOCK_TYPE = "stock_type"
        val PRIMARY_CATEGORY = "primary_category"
        val SECONDARY_CATEGORY = "secondary_category"
        val ORIGIN = "origin"
        val PACKAGE = "package"
        val PACKAGE_UNIT_TYPE = "package_unit_type"
        val PACKAGE_UNIT_VOLUME_IN_MILLILITERS = "package_unit_volume_in_milliliters"
        val TOTAL_PACKAGE_UNITS = "total_package_units"
        val VOLUME_IN_MILLILITERS = "volume_in_milliliters"
        val ALCOHOL_CONTENT = "alcohol_content"
        val PRICE_PER_LITER_OF_ALCOHOL_IN_CENTS = "price_per_liter_of_alcohol_in_cents"
        val PRICE_PER_LITER_IN_CENTS = "price_per_liter_in_cents"
        val INVENTORY_COUNT = "inventory_count"
        val INVENTORY_VOLUME_IN_MILLILITERS = "inventory_volume_in_milliliters"
        val INVENTORY_PRICE_IN_CENTS = "inventory_price_in_cents"
        val SUGAR_CONTENT = "sugar_content"
        val PRODUCER_NAME = "producer_name"
        val RELEASED_ON = "released_on"
        val HAS_VALUE_ADDED_PROMOTION = "has_value_added_promotion"
        val HAS_LIMITED_TIME_OFFER = "has_limited_time_offer"
        val HAS_BONUS_REWARD_MILES = "has_bonus_reward_miles"
        val IS_SEASONAL = "is_seasonal"
        val IS_VQA = "is_vqa"
        val IS_OCB = "is_ocb"
        val IS_KOSHER = "is_kosher"
        val VALUE_ADDED_PROMOTION_DESCRIPTION = "value_added_promotion_description"
        val DESCRIPTION = "description"
        val SERVING_SUGGESTION = "serving_suggestion"
        val TASTING_NOTE = "tasting_note"
        val UPDATED_AT = "updated_at"
        val IMAGE_THUMB_URL = "image_thumb_url"
        val IMAGE_URL = "image_url"
        val VARIETAL = "varietal"
        val STYLE = "style"
        val TERTIARY_CATEGORY = "tertiary_category"
        val SUGAR_IN_GRAMS_PER_LITER = "sugar_in_grams_per_liter"
        val CLEARANCE_SALE_SAVINGS_IN_CENTS = "clearance_sale_savings_in_cents"
        val HAS_CLEARANCE_SALE = "has_clearance_sale"
        val PRODUCT_NO = "product_no"

        fun createTable(db: SQLiteDatabase) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                    ID + " INTEGER PRIMARY KEY," +
                    IS_DEAD + TYPE_TEXT + COMMA_SEP +
                    NAME + TYPE_TEXT + COMMA_SEP +
                    TAGS + TYPE_TEXT + COMMA_SEP +
                    IS_DISCONTINUED + TYPE_TEXT + COMMA_SEP +
                    PRICE_IN_CENTS + TYPE_TEXT + COMMA_SEP +
                    REGULAR_PRICE_IN_CENTS + TYPE_TEXT + COMMA_SEP +
                    LIMITED_TIME_OFFER_SAVINGS_IN_CENTS + TYPE_TEXT + COMMA_SEP +
                    LIMITED_TIME_OFFER_ENDS_ON + TYPE_TEXT + COMMA_SEP +
                    BONUS_REWARD_MILES + TYPE_TEXT + COMMA_SEP +
                    BONUS_REWARD_MILES_ENDS_ON + TYPE_TEXT + COMMA_SEP +
                    STOCK_TYPE + TYPE_TEXT + COMMA_SEP +
                    PRIMARY_CATEGORY + TYPE_TEXT + COMMA_SEP +
                    SECONDARY_CATEGORY + TYPE_TEXT + COMMA_SEP +
                    ORIGIN + TYPE_TEXT + COMMA_SEP +
                    PACKAGE + TYPE_TEXT + COMMA_SEP +
                    PACKAGE_UNIT_TYPE + TYPE_TEXT + COMMA_SEP +
                    PACKAGE_UNIT_VOLUME_IN_MILLILITERS + TYPE_TEXT + COMMA_SEP +
                    TOTAL_PACKAGE_UNITS + TYPE_TEXT + COMMA_SEP +
                    VOLUME_IN_MILLILITERS + TYPE_TEXT + COMMA_SEP +
                    ALCOHOL_CONTENT + TYPE_TEXT + COMMA_SEP +
                    PRICE_PER_LITER_OF_ALCOHOL_IN_CENTS + TYPE_TEXT + COMMA_SEP +
                    PRICE_PER_LITER_IN_CENTS + TYPE_TEXT + COMMA_SEP +
                    INVENTORY_COUNT + TYPE_TEXT + COMMA_SEP +
                    INVENTORY_VOLUME_IN_MILLILITERS + TYPE_TEXT + COMMA_SEP +
                    INVENTORY_PRICE_IN_CENTS + TYPE_TEXT + COMMA_SEP +
                    SUGAR_CONTENT + TYPE_TEXT + COMMA_SEP +
                    PRODUCER_NAME + TYPE_TEXT + COMMA_SEP +
                    RELEASED_ON + TYPE_TEXT + COMMA_SEP +
                    HAS_VALUE_ADDED_PROMOTION + TYPE_TEXT + COMMA_SEP +
                    HAS_LIMITED_TIME_OFFER + TYPE_TEXT + COMMA_SEP +
                    HAS_BONUS_REWARD_MILES + TYPE_TEXT + COMMA_SEP +
                    IS_SEASONAL + TYPE_TEXT + COMMA_SEP +
                    IS_VQA + TYPE_TEXT + COMMA_SEP +
                    IS_OCB + TYPE_TEXT + COMMA_SEP +
                    IS_KOSHER + TYPE_TEXT + COMMA_SEP +
                    VALUE_ADDED_PROMOTION_DESCRIPTION + TYPE_TEXT + COMMA_SEP +
                    DESCRIPTION + TYPE_TEXT + COMMA_SEP +
                    SERVING_SUGGESTION + TYPE_TEXT + COMMA_SEP +
                    TASTING_NOTE + TYPE_TEXT + COMMA_SEP +
                    UPDATED_AT + TYPE_TEXT + COMMA_SEP +
                    IMAGE_THUMB_URL + TYPE_TEXT + COMMA_SEP +
                    IMAGE_URL + TYPE_TEXT + COMMA_SEP +
                    VARIETAL + TYPE_TEXT + COMMA_SEP +
                    STYLE + TYPE_TEXT + COMMA_SEP +
                    TERTIARY_CATEGORY + TYPE_TEXT + COMMA_SEP +
                    SUGAR_IN_GRAMS_PER_LITER + TYPE_TEXT + COMMA_SEP +
                    CLEARANCE_SALE_SAVINGS_IN_CENTS + TYPE_TEXT + COMMA_SEP +
                    HAS_CLEARANCE_SALE + TYPE_TEXT + COMMA_SEP +
                    PRODUCT_NO + TYPE_TEXT +
                    " )")
        }

        fun upgradeTable(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        }

        fun Product.obtainContentValues(): ContentValues {
            val cv = ContentValues()
            cv.put(ID, id)
            cv.put(IS_DEAD, isDead)
            cv.put(NAME, name)
            cv.put(TAGS, tags)
            cv.put(IS_DISCONTINUED, isDiscontinued)
            cv.put(PRICE_IN_CENTS, priceInCents)
            cv.put(REGULAR_PRICE_IN_CENTS, regularPriceInCents)
            cv.put(LIMITED_TIME_OFFER_SAVINGS_IN_CENTS, limitedTimeOfferSavingsInCents)
            cv.put(LIMITED_TIME_OFFER_ENDS_ON, limitedTimeOfferEndsOn)
            cv.put(BONUS_REWARD_MILES, bonusRewardMiles)
            cv.put(BONUS_REWARD_MILES_ENDS_ON, bonusRewardMilesEndsOn)
            cv.put(STOCK_TYPE, stockType)
            cv.put(PRIMARY_CATEGORY, primaryCategory)
            cv.put(SECONDARY_CATEGORY, secondaryCategory)
            cv.put(ORIGIN, origin)
            cv.put(PACKAGE, pac)
            cv.put(PACKAGE_UNIT_TYPE, packageUnitType)
            cv.put(PACKAGE_UNIT_VOLUME_IN_MILLILITERS, packageUnitVolumeInMilliliters)
            cv.put(TOTAL_PACKAGE_UNITS, totalPackageUnits)
            cv.put(VOLUME_IN_MILLILITERS, volumeInMilliliters)
            cv.put(ALCOHOL_CONTENT, alcoholContent)
            cv.put(PRICE_PER_LITER_OF_ALCOHOL_IN_CENTS, pricePerLiterOfAlcoholInCents)
            cv.put(PRICE_PER_LITER_IN_CENTS, pricePerLiterInCents)
            cv.put(INVENTORY_COUNT, inventoryCount)
            cv.put(INVENTORY_VOLUME_IN_MILLILITERS, inventoryVolumeInMilliliters)
            cv.put(INVENTORY_PRICE_IN_CENTS, inventoryPriceInCents)
            cv.put(SUGAR_CONTENT, sugarContent)
            cv.put(PRODUCER_NAME, producerName)
            cv.put(RELEASED_ON, releasedOn)
            cv.put(HAS_VALUE_ADDED_PROMOTION, hasValueAddedPromotion)
            cv.put(HAS_LIMITED_TIME_OFFER, hasLimitedTimeOffer)
            cv.put(HAS_BONUS_REWARD_MILES, hasBonusRewardMiles)
            cv.put(IS_SEASONAL, isSeasonal)
            cv.put(IS_VQA, isVqa)
            cv.put(IS_OCB, isOcb)
            cv.put(IS_KOSHER, isKosher)
            cv.put(VALUE_ADDED_PROMOTION_DESCRIPTION, valueAddedPromotionDescription)
            cv.put(DESCRIPTION, description)
            cv.put(SERVING_SUGGESTION, servingSuggestion)
            cv.put(TASTING_NOTE, tastingNote)
            cv.put(UPDATED_AT, updatedAt)
            cv.put(IMAGE_THUMB_URL, imageThumbUrl)
            cv.put(IMAGE_URL, imageUrl)
            cv.put(VARIETAL, varietal)
            cv.put(STYLE, style)
            cv.put(TERTIARY_CATEGORY, tertiaryCategory)
            cv.put(SUGAR_IN_GRAMS_PER_LITER, sugarInGramsPerLiter)
            cv.put(CLEARANCE_SALE_SAVINGS_IN_CENTS, clearanceSaleSavingsInCents)
            cv.put(HAS_CLEARANCE_SALE, hasClearanceSale)
            cv.put(PRODUCT_NO, productNo)
            return cv
        }
    }

    fun Cursor.obtainProducts(): List<Product> {
        val products = ArrayList<Product>()
        if (moveToFirst())
            do {
                products.add(Product(
                        getLong(getColumnIndex(ID)),
                        getString(getColumnIndex(IS_DEAD)).toBoolean(),
                        getString(getColumnIndex(NAME)),
                        getString(getColumnIndex(TAGS)),
                        getString(getColumnIndex(IS_DISCONTINUED)).toBoolean(),
                        getString(getColumnIndex(PRICE_IN_CENTS)).toInt(),
                        getString(getColumnIndex(REGULAR_PRICE_IN_CENTS)).toInt(),
                        getString(getColumnIndex(LIMITED_TIME_OFFER_SAVINGS_IN_CENTS)).toInt(),
                        getString(getColumnIndex(LIMITED_TIME_OFFER_ENDS_ON)),
                        getString(getColumnIndex(BONUS_REWARD_MILES)).toInt(),
                        getString(getColumnIndex(BONUS_REWARD_MILES_ENDS_ON)),
                        getString(getColumnIndex(STOCK_TYPE)),
                        getString(getColumnIndex(PRIMARY_CATEGORY)),
                        getString(getColumnIndex(SECONDARY_CATEGORY)),
                        getString(getColumnIndex(ORIGIN)),
                        getString(getColumnIndex(PACKAGE)),
                        getString(getColumnIndex(PACKAGE_UNIT_TYPE)),
                        getString(getColumnIndex(PACKAGE_UNIT_VOLUME_IN_MILLILITERS)).toInt(),
                        getString(getColumnIndex(TOTAL_PACKAGE_UNITS)).toInt(),
                        getString(getColumnIndex(VOLUME_IN_MILLILITERS)).toInt(),
                        getString(getColumnIndex(ALCOHOL_CONTENT)).toInt(),
                        getString(getColumnIndex(PRICE_PER_LITER_OF_ALCOHOL_IN_CENTS)).toInt(),
                        getString(getColumnIndex(PRICE_PER_LITER_IN_CENTS)).toInt(),
                        getString(getColumnIndex(INVENTORY_COUNT)).toInt(),
                        getString(getColumnIndex(INVENTORY_VOLUME_IN_MILLILITERS)).toInt(),
                        getString(getColumnIndex(INVENTORY_PRICE_IN_CENTS)).toInt(),
                        getString(getColumnIndex(SUGAR_CONTENT)),
                        getString(getColumnIndex(PRODUCER_NAME)),
                        getString(getColumnIndex(RELEASED_ON)),
                        getString(getColumnIndex(HAS_VALUE_ADDED_PROMOTION)).toBoolean(),
                        getString(getColumnIndex(HAS_LIMITED_TIME_OFFER)).toBoolean(),
                        getString(getColumnIndex(HAS_BONUS_REWARD_MILES)).toBoolean(),
                        getString(getColumnIndex(IS_SEASONAL)).toBoolean(),
                        getString(getColumnIndex(IS_VQA)).toBoolean(),
                        getString(getColumnIndex(IS_OCB)).toBoolean(),
                        getString(getColumnIndex(IS_KOSHER)).toBoolean(),
                        getString(getColumnIndex(VALUE_ADDED_PROMOTION_DESCRIPTION)),
                        getString(getColumnIndex(DESCRIPTION)),
                        getString(getColumnIndex(SERVING_SUGGESTION)),
                        getString(getColumnIndex(TASTING_NOTE)),
                        getString(getColumnIndex(UPDATED_AT)),
                        getString(getColumnIndex(IMAGE_THUMB_URL)),
                        getString(getColumnIndex(IMAGE_URL)),
                        getString(getColumnIndex(VARIETAL)),
                        getString(getColumnIndex(STYLE)),
                        getString(getColumnIndex(TERTIARY_CATEGORY)),
                        getString(getColumnIndex(SUGAR_IN_GRAMS_PER_LITER)).toInt(),
                        getString(getColumnIndex(CLEARANCE_SALE_SAVINGS_IN_CENTS)).toInt(),
                        getString(getColumnIndex(HAS_CLEARANCE_SALE)).toBoolean(),
                        getString(getColumnIndex(PRODUCT_NO)).toLong()

                ))
            } while (moveToFirst())
        close()
        return products
    }
}