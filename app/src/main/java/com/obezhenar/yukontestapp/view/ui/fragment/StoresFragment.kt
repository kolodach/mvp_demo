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
package com.obezhenar.yukontestapp.view.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.obezhenar.yukontestapp.R
import com.obezhenar.yukontestapp.common.extensions.isNetworkAvailable
import com.obezhenar.yukontestapp.model.entity.Store
import com.obezhenar.yukontestapp.presenter.StoresPresenter
import com.obezhenar.yukontestapp.view.StoresView
import com.obezhenar.yukontestapp.view.ui.activity.StoreDetailsActivity
import com.obezhenar.yukontestapp.view.ui.adapter.StoresAdapter
import kotlinx.android.synthetic.main.fragment_stores.*

/**
 * Implements Stores View behaviour
 */
class StoresFragment : MvpAppCompatFragment(), StoresView {
    @InjectPresenter
    lateinit var storesPresenter: StoresPresenter

    private var loading = false

    private val adapter = StoresAdapter({
        startActivity(StoreDetailsActivity
                .getStartIntent(context, it.id))
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater!!.inflate(R.layout.fragment_stores, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        rvStores.layoutManager = layoutManager
        rvStores.adapter = adapter

        rvStores.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (layoutManager.findLastVisibleItemPosition() >= adapter.itemCount - 10
                        && !loading)
                    storesPresenter.loadMoreStores()
            }
        })
        swipeRefresh.setOnRefreshListener {
            if (activity.isNetworkAvailable()) {
                storesPresenter.refreshStores()
                adapter.clean()
            } else {
                Toast.makeText(context, "Network unavailable", Toast.LENGTH_SHORT).show()
            }
        }

        storesPresenter.loadMoreStores()
    }

    override fun onStoresCleared() {
        swipeRefresh.isRefreshing = false
        displayProgress(true)
        adapter.notifyItemChanged(adapter.itemCount - 1)
    }

    override fun onAllItemsLoaded() {
        loading = true
        adapter.isLoading = false
        adapter.notifyItemChanged(adapter.itemCount - 1)
    }

    override fun displayProgress(display: Boolean) {
        loading = display
        adapter.isLoading = display
    }

    override fun addStores(stores: List<Store>) {
        adapter.addStores(stores)
    }
}