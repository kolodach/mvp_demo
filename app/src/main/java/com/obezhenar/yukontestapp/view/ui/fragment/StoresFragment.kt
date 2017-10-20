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
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.obezhenar.yukontestapp.R
import com.obezhenar.yukontestapp.model.entity.Store
import com.obezhenar.yukontestapp.presenter.StoresPresenter
import com.obezhenar.yukontestapp.view.StoresView
import com.obezhenar.yukontestapp.view.ui.adapter.StoresAdapter
import kotlinx.android.synthetic.main.fragment_stores.*

/**
 * Created by 1 on 10/20/2017.
 */
class StoresFragment : MvpAppCompatFragment(), StoresView {
    @InjectPresenter
    lateinit var storesPresenter : StoresPresenter

    private val adapter = StoresAdapter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater!!.inflate(R.layout.fragment_stores, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvStores.layoutManager = LinearLayoutManager(context)
        rvStores.adapter = adapter

        storesPresenter.loadMoreStore()
    }

    override fun displayProgress(display: Boolean) {

    }

    override fun addStores(stores: List<Store>) {
        addStores(stores)
    }
}