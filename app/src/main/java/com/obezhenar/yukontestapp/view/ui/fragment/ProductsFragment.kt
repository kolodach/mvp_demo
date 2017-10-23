package com.obezhenar.yukontestapp.view.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
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

        presenter.loadMoreStores(storeId)
    }

    override fun displayProgress(display: Boolean) {
        adapter.isLoading = true
    }

    override fun onAllLoaded() {

    }

    override fun displayProducts(products: List<Product>) {
        adapter.addAll(products)
    }
}