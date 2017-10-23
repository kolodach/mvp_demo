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

package com.obezhenar.yukontestapp.view.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.obezhenar.yukontestapp.R
import com.obezhenar.yukontestapp.model.entity.Product
import com.obezhenar.yukontestapp.presenter.ProductsPresenter
import com.obezhenar.yukontestapp.view.ProductsView
import com.obezhenar.yukontestapp.view.ui.adapter.ProductsAdapter
import kotlinx.android.synthetic.main.fragment_products.*

/**
 * Created by kolod on 21.10.2017.
 */
class ProductsFragment : MvpAppCompatFragment(), ProductsView {
    @InjectPresenter
    lateinit var presenter: ProductsPresenter
    var storeId = 0L
    var adapter = ProductsAdapter()
    var loading = false

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_products, container, false)
    }

    companion object {
        fun newInstance(storeId: Long): Fragment {
            val fragment = ProductsFragment()
            fragment.storeId = storeId
            return fragment
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        rvProducts.layoutManager = layoutManager
        rvProducts.adapter = adapter

        rvProducts.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (layoutManager.findLastVisibleItemPosition() >= adapter.itemCount - 10
                        && !loading)
                    presenter.loadMoreProducts(storeId)
            }
        })

        presenter.loadMoreProducts(storeId)
    }

    override fun displayProgress(display: Boolean) {
        adapter.isLoading = display
        loading = display
    }

    override fun onAllLoaded() {
        adapter.isLoading = false
        loading = false
        adapter.notifyItemChanged(adapter.itemCount - 1)
    }

    override fun displayProducts(products: List<Product>) {
        adapter.addAll(products)
    }
}