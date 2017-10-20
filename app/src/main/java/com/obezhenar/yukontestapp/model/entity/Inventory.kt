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
package com.obezhenar.yukontestapp.model.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by 1 on 10/19/2017.
 */
data class Inventory(
        @SerializedName("product_id")
        @Expose
        var productId: Long,
        @SerializedName("store_id")
        @Expose
        var storeId: Long,
        @SerializedName("is_dead")
        @Expose
        var isDead: Boolean,
        @SerializedName("quantity")
        @Expose
        var quantity: Int,
        @SerializedName("updated_on")
        @Expose
        var updatedOn: String,
        @SerializedName("updated_at")
        @Expose
        var updatedAt: String,
        @SerializedName("product_no")
        @Expose
        var productNo: Long,
        @SerializedName("store_no")
        @Expose
        var storeNo: Int
)