package com.example.blackcoffer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.blackcoffer.adapters.ViewPagerAdapter
import com.example.blackcoffer.databinding.ActivityMainBinding
import com.example.blackcoffer.fragments.BusinessFragment
import com.example.blackcoffer.fragments.MerchantFragment
import com.example.blackcoffer.fragments.PersonFragment
import com.example.blackcoffer.fragments.RefineFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var personFragment: PersonFragment
    private lateinit var businessFragment: BusinessFragment
    private lateinit var merchantFragment: MerchantFragment
    private lateinit var refineFragment: RefineFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize fragments
        personFragment = PersonFragment()
        businessFragment = BusinessFragment()
        merchantFragment = MerchantFragment()
        refineFragment = RefineFragment()

        // Hide all fragments initially
        supportFragmentManager.beginTransaction()
            .add(R.id.frameLayout, personFragment)
            .hide(personFragment)
            .add(R.id.frameLayout, businessFragment)
            .hide(businessFragment)
            .add(R.id.frameLayout, merchantFragment)
            .hide(merchantFragment)
            .add(R.id.frameLayout, refineFragment)
            .hide(refineFragment)
            .commitNow()

        // Initialize other components
        initialization()

        // Set up bottom navigation
        setupBottomNavigation()

        // Set up TabLayout with ViewPager
        setupTabLayoutWithViewPager()
    }

    private fun setupBottomNavigation() {
        binding.bottomMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.exploreFragment -> {
                    // Show Personal fragment
                    showFragment(personFragment)
                    showTabLayout()
                    true
                }
                R.id.refineFragment -> {
                    // Show Refine fragment and hide tab layout
                    hideTabLayout()
                    showFragment(refineFragment)
                    true
                }
                // Handle other bottom navigation items if needed
                else -> false
            }
        }
    }

    private fun setupTabLayoutWithViewPager() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            // Set tab text based on position
            tab.text = when (position) {
                0 -> "Personal"
                1 -> "Business"
                2 -> "Merchant"
                else -> ""
            }
        }.attach()
    }

    private fun initialization() {
        // Initialize ViewPager adapter
        viewPagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = viewPagerAdapter
        binding.viewPager.offscreenPageLimit = 3
    }

    private fun showTabLayout() {
        // Show the TabLayout
        binding.tabLayout.visibility = View.VISIBLE
    }

    private fun hideTabLayout() {
        // Hide the TabLayout
        binding.tabLayout.visibility = View.GONE
    }

    private fun showFragment(fragment: Fragment) {
        // Hide all fragments and show the specified fragment
        supportFragmentManager.beginTransaction()
            .hide(personFragment)
            .hide(businessFragment)
            .hide(merchantFragment)
            .hide(refineFragment)
            .show(fragment)
            .commitNow()

        // Adjust visibility of frameLayout and viewPager
        binding.frameLayout.visibility = if (fragment == refineFragment) View.VISIBLE else View.GONE
        binding.viewPager.visibility = if (fragment == refineFragment) View.GONE else View.VISIBLE
    }
}
