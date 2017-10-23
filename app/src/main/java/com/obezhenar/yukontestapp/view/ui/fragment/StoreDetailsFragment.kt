package com.obezhenar.yukontestapp.view.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.obezhenar.yukontestapp.R
import com.obezhenar.yukontestapp.common.extensions.doOnClick
import com.obezhenar.yukontestapp.model.entity.Store
import com.obezhenar.yukontestapp.presenter.StoreDetailsPresenter
import com.obezhenar.yukontestapp.view.StoreDetailsView
import kotlinx.android.synthetic.main.fragment_store_details.*
import android.content.Intent
import android.net.Uri


/**
 * Implements store details screen behaviour
 */
class StoreDetailsFragment : MvpAppCompatFragment(), StoreDetailsView {
    var storeId = 0L

    @InjectPresenter
    lateinit var storeDetailsPresenter: StoreDetailsPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_store_details, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        storeDetailsPresenter.loadStoreDetails(storeId)
    }

    companion object {
        fun newInstance(storeId: Long): StoreDetailsFragment {
            val fragment = StoreDetailsFragment()
            fragment.storeId = storeId
            return fragment
        }
    }

    override fun displayStore(store: Store) {
        with(store) {
            activity.title = store.name

            tvAddress.text = "Address: ${store.addressLine1}"
            tvPhone.text = "Phone: ${store.telephone}"

            val stringBuilder = StringBuilder("Features:")
            if (store.hasBeerColdRoom)
                stringBuilder.append("\n- Beer cold room")
            if (store.hasBilingualServices)
                stringBuilder.append("\n- Bilingual services")
            if (store.hasParking)
                stringBuilder.append("\n- Parking")
            if (store.hasProductConsultant)
                stringBuilder.append("\n- Product consultant")
            if (store.hasSpecialOccasionPermits)
                stringBuilder.append("\n- Special occasion permits")
            if (store.hasTastingBar)
                stringBuilder.append("\n- Has testing bar")
            if (store.hasVintagesCorner)
                stringBuilder.append("\n- Has vintages corner")

            tvFeatures.text = stringBuilder.toString()

            btnShowOnMap.doOnClick {
                val gmmIntentUri = Uri.parse("geo:${store.latitude},${store.longitude}" +
                        "?q=${store.latitude},${store.longitude}(${store.addressLine1})")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.`package` = "com.google.android.apps.maps"
                startActivity(mapIntent)
            }
        }
    }

    override fun displayProgress(display: Boolean) {

    }
}