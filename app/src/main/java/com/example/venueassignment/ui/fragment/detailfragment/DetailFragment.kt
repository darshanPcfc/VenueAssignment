package com.example.venueassignment.ui.fragment.detailfragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.venueassignment.BR
import com.example.venueassignment.R
import com.example.venueassignment.base.BaseApplication
import com.example.venueassignment.base.BaseFragment
import com.example.venueassignment.databinding.FragmentVenueDetailBinding
import com.example.venueassignment.networkinterface.remote.response.detail.VenueResponse
import com.example.venueassignment.networkinterface.remote.response.search.Venues
import com.example.venueassignment.ui.activity.MainActivity
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Darshan Patel
 * Usage: DetailFragment displays detail of venue after click on individual venue row in search fragment
 */
class DetailFragment : BaseFragment<FragmentVenueDetailBinding, DetailViewModel>(),
    IDetailNavigator {
    override val viewModel: DetailViewModel by viewModel()
    private lateinit var fragmentVenueDetailBinding: FragmentVenueDetailBinding
    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_venue_detail

    var venues: ArrayList<Venues> = ArrayList()
    lateinit var venueData: Venues

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setNavigator(this)
        val args by navArgs<DetailFragmentArgs>()
        venueData = args.venueParcelData
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentVenueDetailBinding = this.viewDataBinding!!
        fragmentVenueDetailBinding.progressbar.visibility = View.VISIBLE
        onFetchVenueDetailAPI(venueData.id)
    }

    private fun onFetchVenueDetailAPI(venueID: String) {
        if (BaseApplication.hasNetwork()!!) {
            viewModel.detailVenue(venueID).observe(viewLifecycleOwner, Observer {
                if (it != null) {
                    fragmentVenueDetailBinding.progressbar.visibility = View.GONE
                    updateUI(it.response.venues)
                } else {
                    fragmentVenueDetailBinding.progressbar.visibility = View.GONE
                    displayAPIFailureAlert()
                }
            })
        } else {
            fragmentVenueDetailBinding.progressbar.visibility = View.GONE
            Toast.makeText(
                activity,
                getString(R.string.str_network_connection_error),
                Toast.LENGTH_LONG
            ).show()
        }

    }

    private fun updateUI(venues: VenueResponse) {
        fragmentVenueDetailBinding.data = venues
    }
}