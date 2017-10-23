/**
 * Copyright © 2017 Oleg Bezhenar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http:
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.obezhenar.yukontestapp.model.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * LCBO Store entity
 */
data class Store(
        @SerializedName("id")
        @Expose
		val id: Long,
        @SerializedName("is_dead")
        @Expose
		val isDead: Boolean,
        @SerializedName("name")
        @Expose
		val name: String,
        @SerializedName("tags")
        @Expose
		val tags: String,
        @SerializedName("address_line_1")
        @Expose
		val addressLine1: String,
        @SerializedName("address_line_2")
        @Expose
		val addressLine2: String?,
        @SerializedName("city")
        @Expose
		val city: String,
        @SerializedName("postal_code")
        @Expose
		val postalCode: String,
        @SerializedName("telephone")
        @Expose
		val telephone: String,
        @SerializedName("fax")
        @Expose
		val fax: String,
        @SerializedName("latitude")
        @Expose
		val latitude: Double,
        @SerializedName("longitude")
        @Expose
		val longitude: Double,
        @SerializedName("products_count")
        @Expose
		val productsCount: Int,
        @SerializedName("inventory_count")
        @Expose
		val inventoryCount: Int,
        @SerializedName("inventory_price_in_cents")
        @Expose
		val inventoryPriceInCents: Int,
        @SerializedName("inventory_volume_in_milliliters")
        @Expose
		val inventoryVolumeInMilliliters: Int,
        @SerializedName("has_wheelchair_accessability")
        @Expose
		val hasWheelchairAccessability: Boolean,
        @SerializedName("has_bilingual_services")
        @Expose
		val hasBilingualServices: Boolean,
        @SerializedName("has_product_consultant")
        @Expose
		val hasProductConsultant: Boolean,
        @SerializedName("has_tasting_bar")
        @Expose
		val hasTastingBar: Boolean,
        @SerializedName("has_beer_cold_room")
        @Expose
		val hasBeerColdRoom: Boolean,
        @SerializedName("has_special_occasion_permits")
        @Expose
		val hasSpecialOccasionPermits: Boolean,
        @SerializedName("has_vintages_corner")
        @Expose
		val hasVintagesCorner: Boolean,
        @SerializedName("has_parking")
        @Expose
		val hasParking: Boolean,
        @SerializedName("has_transit_access")
        @Expose
		val hasTransitAccess: Boolean,
        @SerializedName("sunday_open")
        @Expose
		val sundayOpen: Int,
        @SerializedName("sunday_close")
        @Expose
		val sundayClose: Int,
        @SerializedName("monday_open")
        @Expose
		val mondayOpen: Int,
        @SerializedName("monday_close")
        @Expose
		val mondayClose: Int,
        @SerializedName("tuesday_open")
        @Expose
		val tuesdayOpen: Int,
        @SerializedName("tuesday_close")
        @Expose
		val tuesdayClose: Int,
        @SerializedName("wednesday_open")
        @Expose
		val wednesdayOpen: Int,
        @SerializedName("wednesday_close")
        @Expose
		val wednesdayClose: Int,
        @SerializedName("thursday_open")
        @Expose
		val thursdayOpen: Int,
        @SerializedName("thursday_close")
        @Expose
		val thursdayClose: Int,
        @SerializedName("friday_open")
        @Expose
		val fridayOpen: Int,
        @SerializedName("friday_close")
        @Expose
		val fridayClose: Int,
        @SerializedName("saturday_open")
        @Expose
		val saturdayOpen: Int,
        @SerializedName("saturday_close")
        @Expose
		val saturdayClose: Int,
        @SerializedName("updated_at")
        @Expose
		val updatedAt: String,
        @SerializedName("store_no")
        @Expose
		val storeNo: Int
)