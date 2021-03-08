package com.example.venueassignment.ui.fragment.searchfragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.NavDirections
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.venueassignment.BR
import com.example.venueassignment.R
import com.example.venueassignment.base.BaseApplication
import com.example.venueassignment.base.BaseFragment
import com.example.venueassignment.databinding.FragmentVenueSearchBinding
import com.example.venueassignment.db.VenueDataSet
import com.example.venueassignment.db.VenueViewModel
import com.example.venueassignment.networkinterface.remote.response.search.Venues
import com.example.venueassignment.ui.activity.MainActivity
import com.example.venueassignment.ui.adapters.SearchListAdapter
import kotlinx.android.synthetic.main.fragment_venue_search.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * Created by Darshan Patel
 * Usage: searching foe venues based on city entered by user
 */
class SearchFragment : BaseFragment<FragmentVenueSearchBinding, SearchViewModel>(),
    ISearchNavigator {

    override val viewModel: SearchViewModel by viewModel()
    private lateinit var fragmentSearchBinding: FragmentVenueSearchBinding
    override val bindingVariable: Int
        get() = BR.viewModel
    private lateinit var searchListAdapter: SearchListAdapter
    var venues: ArrayList<Venues> = ArrayList()

    override val layoutId: Int
        get() = R.layout.fragment_venue_search

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setNavigator(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentSearchBinding = this.viewDataBinding!!
        setRecyclerView()
    }

    private fun callSearchVenueAPI(searchStr: String) {
        try {
            if (BaseApplication.hasNetwork()!!) {
                viewModel.search(searchStr).observe(viewLifecycleOwner, {
                    hideKeyboard()
                    if (it != null) {
                        if (venues.size > 0)
                            venues.clear()
                        venues.addAll(it.response.venues)
                        refreshData(venues)
                    } else {
                        fragmentSearchBinding.progressbar.visibility = View.GONE
                        displayAPIFailureAlert()
                    }
                })
            } else {
                //fetch data from venue table of data base
                val venueViewModel = VenueViewModel(BaseApplication.instance!!)
                venueViewModel.allVenues.observe(viewLifecycleOwner, {
                    if (it.isNotEmpty()) {
                        venues.clear()
                        venues.addAll(it)
                        VenueDataSet.closeCursor()
                        refreshData(venues)
                    } else {
                        fragmentSearchBinding.progressbar.visibility = View.GONE
                        Toast.makeText(activity, getString(R.string.str_no_data), Toast.LENGTH_LONG)
                            .show()
                    }
                })
            }
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    private fun refreshData(list: ArrayList<Venues>) {
        fragmentSearchBinding.progressbar.visibility = View.GONE
        searchListAdapter.setVenueList(list)
        //insert data
        val venueViewModel = VenueViewModel(BaseApplication.instance!!)
        GlobalScope.launch {
            list.forEach {
                venueViewModel.insert(it)
            }
            VenueDataSet.closeCursor()
        }
    }

    private fun setRecyclerView() {
        rv_search_venues.layoutManager = LinearLayoutManager(context)
        searchListAdapter = SearchListAdapter(this)
        rv_search_venues.adapter = searchListAdapter
    }

    override fun onVenueListItemCLick(item: Venues) {
        clearSearchEditText()
        val action: NavDirections = SearchFragmentDirections.openDetailFragment(item)
        navController.navigate(action)
    }

    override fun onSearchGoClicked(searchStr: String) {
        fragmentSearchBinding.progressbar.visibility = View.VISIBLE
        callSearchVenueAPI(searchStr)
    }

    private fun clearSearchEditText() {
        fragmentSearchBinding.etSearch.text.clear()
    }

    override fun enterTextMessage() {
        Toast.makeText(activity, getString(R.string.str_enter_text_prompt), Toast.LENGTH_LONG)
            .show()
    }
}