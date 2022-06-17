package com.droidyme.mysoc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droidyme.mysoc.R
import com.droidyme.mysoc.adapter.InHouseBusinessAdapter
import com.droidyme.mysoc.databinding.ActivityInHouseBusinessBinding
import com.droidyme.mysoc.utility.closeScreen

class InHouseBusinessActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInHouseBusinessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_in_house_business)
        init()
    }

    private fun init() {
        binding.toolBarLayout.toolBar.title = "In-house business"
        setSupportActionBar(binding.toolBarLayout.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolBarLayout.toolBar.setNavigationOnClickListener { closeScreen() }

        binding.businessRecyclerView.adapter = InHouseBusinessAdapter(this)
    }

    override fun onBackPressed() {
        closeScreen()
    }
}