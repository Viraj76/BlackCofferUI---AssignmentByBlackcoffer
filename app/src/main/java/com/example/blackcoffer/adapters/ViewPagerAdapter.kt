package com.example.blackcoffer.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.blackcoffer.fragments.BusinessFragment
import com.example.blackcoffer.fragments.MerchantFragment
import com.example.blackcoffer.fragments.PersonFragment


// view pager for sliding between these fragments
class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PersonFragment()
            1 -> BusinessFragment()
            2 -> MerchantFragment()
            else -> PersonFragment()
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}
