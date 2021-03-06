package com.example.abnambrotest.ui.fragment.searchfragment

import com.example.abnambrotest.ni.remote.response.search.Venues

interface ISearchNavigator {
    fun onVenueListItemCLick(item: Venues)
    fun onSearchGoClicked(searchList : String)
    fun enterTextMessage()
}