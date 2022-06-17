package com.droidyme.mysoc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droidyme.mysoc.R
import com.droidyme.mysoc.adapter.MeetingPagerAdapter
import com.droidyme.mysoc.adapter.RentSellPagerAdapter
import com.droidyme.mysoc.databinding.ActivityRentSellListBinding
import com.droidyme.mysoc.utility.closeScreen
import com.google.android.material.tabs.TabLayoutMediator

class RentSellListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRentSellListBinding
    val tabs = arrayOf(
        "Rent",
        "Sell"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rent_sell_list)
        init()
    }

    private fun init() {
        binding.toolBarLayout.toolBar.title = "Rent/Sell House"
        setSupportActionBar(binding.toolBarLayout.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolBarLayout.toolBar.setNavigationOnClickListener { closeScreen() }

        binding.viewPager.adapter = RentSellPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabs[position]
        }.attach()
    }

    override fun onBackPressed() {
        closeScreen()
    }
}