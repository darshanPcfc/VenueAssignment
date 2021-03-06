package com.example.abnambrotest.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abnambrotest.databinding.VenueRowBinding
import com.example.abnambrotest.ni.remote.response.search.Venues
import com.example.abnambrotest.ui.fragment.searchfragment.ISearchNavigator

class SearchListAdapter(var iSearchNavigator: ISearchNavigator) :
    RecyclerView.Adapter<SearchListAdapter.ViewHolder>() {

    var items: ArrayList<Venues> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = VenueRowBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    fun setVenueList(items: ArrayList<Venues>) {
        this.items = items
        Log.d("_Adapter","Internet Present" + items.size)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    inner class ViewHolder(val binding: VenueRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Venues) {
            binding.item = item
            binding.cvVenue.setOnClickListener {
                iSearchNavigator.onVenueListItemCLick(item)
            }
            binding.executePendingBindings()
        }
    }
}