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
import com.obezhenar.yukontestapp.model.entity.Store
import kotlinx.android.synthetic.main.item_view.view.*

/**
 * Created by 1 on 10/20/2017.
 */
class StoresAdapter : RecyclerView.Adapter<StoresAdapter.StoreViewHolder>() {
    private val stores = ArrayList<Store>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): StoreViewHolder =
            StoreViewHolder(LayoutInflater.from(parent!!.context)
                    .inflate(R.layout.item_view, parent, false))

    override fun onBindViewHolder(holder: StoreViewHolder?, position: Int) {
        val store = stores[position]
        with(holder!!.itemView) {
            tvTitle.text = store.name
            tvAddress.text = store.addressLine1
        }
    }

    override fun getItemCount(): Int = stores.size

    fun addStores(storesToAdd: List<Store>) {
        stores.addAll(storesToAdd)
        notifyDataSetChanged()
    }

    class StoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}