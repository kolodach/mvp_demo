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

package com.obezhenar.yukontestapp.view.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.obezhenar.yukontestapp.R
import com.obezhenar.yukontestapp.common.extensions.setVisible
import com.obezhenar.yukontestapp.model.entity.Product
import com.obezhenar.yukontestapp.model.entity.Store
import com.obezhenar.yukontestapp.view.ui.adapter.view_holder.ProgressViewHolder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_product.view.*

/**
 * Created by kolod on 23.10.2017.
 */
class ProductsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val products = ArrayList<Product>()
    private val VIEW_TYPE_ITEM = 1
    private val VIEW_TYPE_PROGRESS = 2

    var isLoading = false

    override fun getItemViewType(position: Int): Int {
        return if (position == itemCount - 1)
            VIEW_TYPE_PROGRESS
        else
            VIEW_TYPE_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val inflate = LayoutInflater.from(parent!!.context)
        return if (viewType == VIEW_TYPE_PROGRESS)
            ProgressViewHolder(inflate.inflate(R.layout.item_progress, parent, false))
        else StoresAdapter.StoreViewHolder(inflate.inflate(R.layout.item_product, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (getItemViewType(position) == VIEW_TYPE_ITEM) {
            val product = products[position]
            with(holder!!.itemView) {
                tvName.text = product.name
                tvCategory.text = product.primaryCategory
                tvPrice.text = (product.priceInCents / 100F).toString()
                Picasso.with(context).load(product.imageThumbUrl).into(ivProduct)
            }
        } else {
            holder!!.itemView.setVisible(isLoading)
        }

    }

    fun addAll(items: List<Product>) {
        products.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount() = products.size + 1
}