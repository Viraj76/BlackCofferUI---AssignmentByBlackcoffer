package com.example.blackcoffer

import android.widget.Filter
import java.util.Locale

class FilterPlayers(
    private val adapter: PlayerAdapter,
    private val filterList: ArrayList<Players>
) : Filter() {
    override fun performFiltering(constraint: CharSequence?): FilterResults {
        val results = FilterResults()
        if (!constraint.isNullOrEmpty()) {

            val query = constraint.toString().trim().uppercase(Locale.getDefault())
            val keywords = query.split(" ")
            val filteredPosts = ArrayList<Players>()

            for (post in filterList) {
                if (keywords.any { keyword ->
                                post.name?.uppercase(Locale.getDefault())?.contains(keyword) == true ||
                                post.city?.uppercase(Locale.getDefault())?.contains(keyword) == true ||
                                post.age?.uppercase(Locale.getDefault())?.contains(keyword) == true
                    }
                ) {
                    filteredPosts.add(post)
                }
            }

            results.count = filteredPosts.size
            results.values = filteredPosts

        } else {
            results.count = filterList.size
            results.values = filterList
        }
        return results
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults) {
        adapter.differ.submitList(results.values as ArrayList<Players>)
    }
}