package com.obezhenar.yukontestapp.view.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.arellomobile.mvp.MvpAppCompatActivity
import com.obezhenar.yukontestapp.R
import com.obezhenar.yukontestapp.view.ui.adapter.StoreDetailsPagerAdapter
import kotlinx.android.synthetic.main.activity_store_details.*

/**
 * Created by kolod on 21.10.2017.
 */
class StoreDetailsActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_details)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val pagerAdapter = StoreDetailsPagerAdapter(supportFragmentManager,
                intent.getLongExtra(STORE_ID, 0L))
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item!!.itemId == android.R.id.home)
            onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    companion object {
        val STORE_ID = "storeId"

        fun getStartIntent(context: Context, storeId: Long): Intent {
            val intent = Intent(context, StoreDetailsActivity::class.java)
            intent.putExtra(STORE_ID, storeId)
            return intent
        }
    }
}