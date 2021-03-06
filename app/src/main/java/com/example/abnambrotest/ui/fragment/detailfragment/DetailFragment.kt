package com.example.abnambrotest.ui.fragment.detailfragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.abnambrotest.BR
import com.example.abnambrotest.R
import com.example.abnambrotest.base.BaseApplication
import com.example.abnambrotest.base.BaseFragment
import com.example.abnambrotest.databinding.FragmentVenueDetailBinding
import com.example.abnambrotest.ni.remote.response.search.Venues
import org.koin.android.viewmodel.ext.android.viewModel

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
        //val args by navArgs<DetailFragmentArgs>()
        val args by navArgs<DetailFragmentArgs>()
        venueData = args.venueParcelData
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentVenueDetailBinding = this.viewDataBinding!!
        onFetchVenueDetailAPI(venueData.id)
    }

    private fun onFetchVenueDetailAPI(venueID: String) {
        if (BaseApplication.hasNetwork()){
            viewModel.detailVenue(venueID).observe(viewLifecycleOwner, Observer {
                if(it != null){
                    Log.d("_DetailFragment","Success Data" + it.response.venues.description)
                }
            })
        }else{
            Toast.makeText(activity,"No Internet", Toast.LENGTH_LONG).show()
        }

    }
}