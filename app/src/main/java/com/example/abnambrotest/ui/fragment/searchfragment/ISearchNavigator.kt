package com.example.abnambrotest.ui.fragment.searchfragment

import com.example.abnambrotest.networkinterface.remote.response.search.Venues

/**
 * Created by Darshan Patel
 * Usage: all clicks and navigation for SearchFragment UI included here
 */
interface ISearchNavigator {
    fun onVenueListItemCLick(item: Venues)
    fun onSearchGoClicked(searchStr: String)
    fun enterTextMessage()
}