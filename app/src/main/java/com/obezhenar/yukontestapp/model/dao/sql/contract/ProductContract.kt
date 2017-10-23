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
    }
}

fun Product.obtainContentValues(): ContentValues {
    val cv = ContentValues()
    cv.put(ProductContract.ID, id)
    cv.put(ProductContract.IS_DEAD, isDead)
    cv.put(ProductContract.NAME, name)
    cv.put(ProductContract.TAGS, tags)
    cv.put(ProductContract.IS_DISCONTINUED, isDiscontinued)
    cv.put(ProductContract.PRICE_IN_CENTS, priceInCents)
    cv.put(ProductContract.REGULAR_PRICE_IN_CENTS, regularPriceInCents)
    cv.put(ProductContract.LIMITED_TIME_OFFER_SAVINGS_IN_CENTS, limitedTimeOfferSavingsInCents)
    cv.put(ProductContract.LIMITED_TIME_OFFER_ENDS_ON, limitedTimeOfferEndsOn)
    cv.put(ProductContract.BONUS_REWARD_MILES, bonusRewardMiles)
    cv.put(ProductContract.BONUS_REWARD_MILES_ENDS_ON, bonusRewardMilesEndsOn)
    cv.put(ProductContract.STOCK_TYPE, stockType)
    cv.put(ProductContract.PRIMARY_CATEGORY, primaryCategory)
    cv.put(ProductContract.SECONDARY_CATEGORY, secondaryCategory)
    cv.put(ProductContract.ORIGIN, origin)
    cv.put(ProductContract.PACKAGE, pac)
    cv.put(ProductContract.PACKAGE_UNIT_TYPE, packageUnitType)
    cv.put(ProductContract.PACKAGE_UNIT_VOLUME_IN_MILLILITERS, packageUnitVolumeInMilliliters)
    cv.put(ProductContract.TOTAL_PACKAGE_UNITS, totalPackageUnits)
    cv.put(ProductContract.VOLUME_IN_MILLILITERS, volumeInMilliliters)
    cv.put(ProductContract.ALCOHOL_CONTENT, alcoholContent)
    cv.put(ProductContract.PRICE_PER_LITER_OF_ALCOHOL_IN_CENTS, pricePerLiterOfAlcoholInCents)
    cv.put(ProductContract.PRICE_PER_LITER_IN_CENTS, pricePerLiterInCents)
    cv.put(ProductContract.INVENTORY_COUNT, inventoryCount)
    cv.put(ProductContract.INVENTORY_VOLUME_IN_MILLILITERS, inventoryVolumeInMilliliters)
    cv.put(ProductContract.INVENTORY_PRICE_IN_CENTS, inventoryPriceInCents)
    cv.put(ProductContract.SUGAR_CONTENT, sugarContent)
    cv.put(ProductContract.PRODUCER_NAME, producerName)
    cv.put(ProductContract.RELEASED_ON, releasedOn)
    cv.put(ProductContract.HAS_VALUE_ADDED_PROMOTION, hasValueAddedPromotion)
    cv.put(ProductContract.HAS_LIMITED_TIME_OFFER, hasLimitedTimeOffer)
    cv.put(ProductContract.HAS_BONUS_REWARD_MILES, hasBonusRewardMiles)
    cv.put(ProductContract.IS_SEASONAL, isSeasonal)
    cv.put(ProductContract.IS_VQA, isVqa)
    cv.put(ProductContract.IS_OCB, isOcb)
    cv.put(ProductContract.IS_KOSHER, isKosher)
    cv.put(ProductContract.VALUE_ADDED_PROMOTION_DESCRIPTION, valueAddedPromotionDescription)
    cv.put(ProductContract.DESCRIPTION, description)
    cv.put(ProductContract.SERVING_SUGGESTION, servingSuggestion)
    cv.put(ProductContract.TASTING_NOTE, tastingNote)
    cv.put(ProductContract.UPDATED_AT, updatedAt)
    cv.put(ProductContract.IMAGE_THUMB_URL, imageThumbUrl)
    cv.put(ProductContract.IMAGE_URL, imageUrl)
    cv.put(ProductContract.VARIETAL, varietal)
    cv.put(ProductContract.STYLE, style)
    cv.put(ProductContract.TERTIARY_CATEGORY, tertiaryCategory)
    cv.put(ProductContract.SUGAR_IN_GRAMS_PER_LITER, sugarInGramsPerLiter)
    cv.put(ProductContract.CLEARANCE_SALE_SAVINGS_IN_CENTS, clearanceSaleSavingsInCents)
    cv.put(ProductContract.HAS_CLEARANCE_SALE, hasClearanceSale)
    cv.put(ProductContract.PRODUCT_NO, productNo)
    return cv
}


fun Cursor.obtainProducts(): List<Product> {
    val products = ArrayList<Product>()
    use {
        if (moveToFirst())
            do {
                products.add(Product(
                        getLong(getColumnIndex(ProductContract.ID)),
                        getString(getColumnIndex(ProductContract.IS_DEAD)) == "1",
                        getString(getColumnIndex(ProductContract.NAME)),
                        "",
                        getString(getColumnIndex(ProductContract.IS_DISCONTINUED)) == "1",
                        getString(getColumnIndex(ProductContract.PRICE_IN_CENTS)).toInt(),
                        getString(getColumnIndex(ProductContract.REGULAR_PRICE_IN_CENTS)).toInt(),
                        getString(getColumnIndex(ProductContract.LIMITED_TIME_OFFER_SAVINGS_IN_CENTS)).toInt(),
                        getString(getColumnIndex(ProductContract.LIMITED_TIME_OFFER_ENDS_ON)),
                        getString(getColumnIndex(ProductContract.BONUS_REWARD_MILES)).toInt(),
                        getString(getColumnIndex(ProductContract.BONUS_REWARD_MILES_ENDS_ON)),
                        getString(getColumnIndex(ProductContract.STOCK_TYPE)),
                        getString(getColumnIndex(ProductContract.PRIMARY_CATEGORY)),
                        getString(getColumnIndex(ProductContract.SECONDARY_CATEGORY)),
                        getString(getColumnIndex(ProductContract.ORIGIN)),
                        getString(getColumnIndex(ProductContract.PACKAGE)),
                        getString(getColumnIndex(ProductContract.PACKAGE_UNIT_TYPE)),
                        getString(getColumnIndex(ProductContract.PACKAGE_UNIT_VOLUME_IN_MILLILITERS)).toInt(),
                        getString(getColumnIndex(ProductContract.TOTAL_PACKAGE_UNITS)).toInt(),
                        getString(getColumnIndex(ProductContract.VOLUME_IN_MILLILITERS)).toInt(),
                        getString(getColumnIndex(ProductContract.ALCOHOL_CONTENT)).toInt(),
                        getString(getColumnIndex(ProductContract.PRICE_PER_LITER_OF_ALCOHOL_IN_CENTS)).toInt(),
                        getString(getColumnIndex(ProductContract.PRICE_PER_LITER_IN_CENTS)).toInt(),
                        getString(getColumnIndex(ProductContract.INVENTORY_COUNT)).toInt(),
                        getString(getColumnIndex(ProductContract.INVENTORY_VOLUME_IN_MILLILITERS)).toInt(),
                        getString(getColumnIndex(ProductContract.INVENTORY_PRICE_IN_CENTS)).toInt(),
                        getString(getColumnIndex(ProductContract.SUGAR_CONTENT)),
                        getString(getColumnIndex(ProductContract.PRODUCER_NAME)),
                        getString(getColumnIndex(ProductContract.RELEASED_ON)),
                        getString(getColumnIndex(ProductContract.HAS_VALUE_ADDED_PROMOTION)) == "1",
                        getString(getColumnIndex(ProductContract.HAS_LIMITED_TIME_OFFER)) == "1",
                        getString(getColumnIndex(ProductContract.HAS_BONUS_REWARD_MILES)) == "1",
                        getString(getColumnIndex(ProductContract.IS_SEASONAL)) == "1",
                        getString(getColumnIndex(ProductContract.IS_VQA)) == "1",
                        getString(getColumnIndex(ProductContract.IS_OCB)) == "1",
                        getString(getColumnIndex(ProductContract.IS_KOSHER)) == "1",
                        getString(getColumnIndex(ProductContract.VALUE_ADDED_PROMOTION_DESCRIPTION)),
                        getString(getColumnIndex(ProductContract.DESCRIPTION)),
                        getString(getColumnIndex(ProductContract.SERVING_SUGGESTION)),
                        getString(getColumnIndex(ProductContract.TASTING_NOTE)),
                        getString(getColumnIndex(ProductContract.UPDATED_AT)),
                        getString(getColumnIndex(ProductContract.IMAGE_THUMB_URL)),
                        getString(getColumnIndex(ProductContract.IMAGE_URL)),
                        getString(getColumnIndex(ProductContract.VARIETAL)),
                        getString(getColumnIndex(ProductContract.STYLE)),
                        getString(getColumnIndex(ProductContract.TERTIARY_CATEGORY)),
                        getString(getColumnIndex(ProductContract.SUGAR_IN_GRAMS_PER_LITER))?.toInt(),
                        getString(getColumnIndex(ProductContract.CLEARANCE_SALE_SAVINGS_IN_CENTS)).toInt(),
                        getString(getColumnIndex(ProductContract.HAS_CLEARANCE_SALE)) == "1",
                        getString(getColumnIndex(ProductContract.PRODUCT_NO)).toLong()
                ))
            } while (moveToNext())
    }
    return products
}
