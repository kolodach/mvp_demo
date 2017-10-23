package com.obezhenar.yukontestapp.view.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.obezhenar.yukontestapp.view.ui.fragment.ProductsFragment
import com.obezhenar.yukontestapp.view.ui.fragment.StoreDetailsFragment

/**
 * Created by kolod on 21.10.2017.
 */
class StoreDetailsPagerAdapter(
        fm: FragmentManager,
        val storeId: Long)
    : FragmentPagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence {
        return if (position == 0)
            "Details"
        else
            "Products"
    }

    override fun getItem(position: Int): Fragment {
        if (position == 0)
            return StoreDetailsFragment.newInstance(storeId)
        else
            return ProductsFragment.newInstance(storeId)
    }

    override fun getCount(): Int = 2
}