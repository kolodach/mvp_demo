/** Copyright © 2017 Oleg Bezhenar
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
package com.obezhenar.yukontestapp.model.entity

import com.google.gson.annotations.SerializedName

/**
 * This data class represents Product entity.
 * @see <a href="https://lcboapi.com/docs/v1/products">LCBO Product Documentation</a>
 */
data class Product(
        @SerializedName("id")
        var id: Long,
        @SerializedName("is_dead")
        var isDead: Boolean,
        @SerializedName("name")
        var name: String,
        @SerializedName("tags")
        var tags: String,
        @SerializedName("is_discontinued")
        var isDiscontinued: Boolean,
        @SerializedName("price_in_cents")
        var priceInCents: Int,
        @SerializedName("regular_price_in_cents")
        var regularPriceInCents: Int,
        @SerializedName("limited_time_offer_savings_in_cents")
        var limitedTimeOfferSavingsInCents: Int,
        @SerializedName("limited_time_offer_ends_on")
        var limitedTimeOfferEndsOn: String?,
        @SerializedName("bonus_reward_miles")
        var bonusRewardMiles: Int,
        @SerializedName("bonus_reward_miles_ends_on")
        var bonusRewardMilesEndsOn: String,
        @SerializedName("stock_type")
        var stockType: String,
        @SerializedName("primary_category")
        var primaryCategory: String,
        @SerializedName("secondary_category")
        var secondaryCategory: String,
        @SerializedName("origin")
        var origin: String,
        @SerializedName("package")
        var pac: String,
        @SerializedName("package_unit_type")
        var packageUnitType: String,
        @SerializedName("package_unit_volume_in_milliliters")
        var packageUnitVolumeInMilliliters: Int,
        @SerializedName("total_package_units")
        var totalPackageUnits: Int,
        @SerializedName("volume_in_milliliters")
        var volumeInMilliliters: Int,
        @SerializedName("alcohol_content")
        var alcoholContent: Int,
        @SerializedName("price_per_liter_of_alcohol_in_cents")
        var pricePerLiterOfAlcoholInCents: Int,
        @SerializedName("price_per_liter_in_cents")
        var pricePerLiterInCents: Int,
        @SerializedName("inventory_count")
        var inventoryCount: Int,
        @SerializedName("inventory_volume_in_milliliters")
        var inventoryVolumeInMilliliters: Int,
        @SerializedName("inventory_price_in_cents")
        var inventoryPriceInCents: Int,
        @SerializedName("sugar_content")
        var sugarContent: String,
        @SerializedName("producer_name")
        var producerName: String,
        @SerializedName("released_on")
        var releasedOn: String?,
        @SerializedName("has_value_added_promotion")
        var hasValueAddedPromotion: Boolean,
        @SerializedName("has_limited_time_offer")
        var hasLimitedTimeOffer: Boolean,
        @SerializedName("has_bonus_reward_miles")
        var hasBonusRewardMiles: Boolean,
        @SerializedName("is_seasonal")
        var isSeasonal: Boolean,
        @SerializedName("is_vqa")
        var isVqa: Boolean,
        @SerializedName("is_ocb")
        var isOcb: Boolean,
        @SerializedName("is_kosher")
        var isKosher: Boolean,
        @SerializedName("value_added_promotion_description")
        var valueAddedPromotionDescription: String?,
        @SerializedName("description")
        var description: String?,
        @SerializedName("serving_suggestion")
        var servingSuggestion: String?,
        @SerializedName("tasting_note")
        var tastingNote: String?,
        @SerializedName("updated_at")
        var updatedAt: String?,
        @SerializedName("image_thumb_url")
        var imageThumbUrl: String,
        @SerializedName("image_url")
        var imageUrl: String,
        @SerializedName("varietal")
        var varietal: String,
        @SerializedName("style")
        var style: String,
        @SerializedName("tertiary_category")
        var tertiaryCategory: String,
        @SerializedName("sugar_in_grams_per_liter")
        var sugarInGramsPerLiter: Int?,
        @SerializedName("clearance_sale_savings_in_cents")
        var clearanceSaleSavingsInCents: Int,
        @SerializedName("has_clearance_sale")
        var hasClearanceSale: Boolean,
        @SerializedName("product_no")
        var productNo: Long
)