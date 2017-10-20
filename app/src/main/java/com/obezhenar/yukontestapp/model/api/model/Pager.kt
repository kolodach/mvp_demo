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
package com.obezhenar.yukontestapp.model.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Pager object from the API response. Represents pagination (current page, previous, next and so).
 */

data class Pager(
        @SerializedName("records_per_page")
        @Expose
        val recordsPerPage: Int,
        @SerializedName("total_record_count")
        @Expose
        val totalRecordCount: Int,
        @SerializedName("current_page_record_count")
        @Expose
        val currentPageRecordCount: Int,
        @SerializedName("is_first_page")
        @Expose
        val isFirstPage: Boolean,
        @SerializedName("is_final_page")
        @Expose
        val isFinalPage: Boolean,
        @SerializedName("current_page")
        @Expose
        val currentPage: Int,
        @SerializedName("current_page_path")
        @Expose
        val currentPagePath: String,
        @SerializedName("next_page")
        @Expose
        val nextPage: Int?,
        @SerializedName("next_page_path")
        @Expose
        val nextPagePath: String?,
        @SerializedName("previous_page")
        @Expose
        val previousPage: Int?,
        @SerializedName("previous_page_path")
        @Expose
        val previousPagePath: String?,
        @SerializedName("total_pages")
        @Expose
        val totalPages: Int,
        @SerializedName("total_pages_path")
        @Expose
        val totalPagesPath: String
)
