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
package com.obezhenar.yukontestapp.view.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.obezhenar.yukontestapp.R
import com.obezhenar.yukontestapp.common.extensions.doOnClick
import com.obezhenar.yukontestapp.common.extensions.setVisible
import com.obezhenar.yukontestapp.model.entity.Store
import com.obezhenar.yukontestapp.view.ui.adapter.view_holder.ProgressViewHolder
import kotlinx.android.synthetic.main.item_store.view.*
import kotlin.properties.Delegates

/**
 * Created by 1 on 10/20/2017.
 */
class StoresAdapter(private val onItemClickListener: (Store) -> Unit)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val stores = ArrayList<Store>()
    private val VIEW_TYPE_ITEM = 1
    private val VIEW_TYPE_PROGRESS = 2

    var isLoading = false

    override fun getItemViewType(position: Int): Int {
        return if (position == itemCount - 1)
            VIEW_TYPE_PROGRESS
        else
            VIEW_TYPE_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        return if (viewType == VIEW_TYPE_PROGRESS)
            ProgressViewHolder(inflate.inflate(R.layout.item_progress, parent, false))
        else StoreViewHolder(inflate.inflate(R.layout.item_store, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (getItemViewType(position) == VIEW_TYPE_ITEM) {
            val store = stores[position]
            with(holder!!.itemView) {
                tvTitle.text = store.name
                tvAddress.text = store.addressLine1
                doOnClick { onItemClickListener.invoke(store) }
            }
        } else {
            holder!!.itemView.setVisible(isLoading)
        }
    }

    override fun getItemCount(): Int = stores.size + 1

    fun addStores(storesToAdd: List<Store>) {
        stores.addAll(storesToAdd)
        notifyDataSetChanged()
    }

    fun clean() {
        stores.clear()
        notifyDataSetChanged()
    }

    class StoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}