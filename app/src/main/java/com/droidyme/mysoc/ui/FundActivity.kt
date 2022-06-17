package com.droidyme.mysoc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droidyme.mysoc.R
import com.droidyme.mysoc.adapter.FundAdapter
import com.droidyme.mysoc.databinding.ActivityFundBinding
import com.droidyme.mysoc.utility.closeScreen

class FundActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFundBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fund)
        init()
    }

    private fun init() {
        binding.toolBarLayout.toolBar.title = ""
        setSupportActionBar(binding.toolBarLayout.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolBarLayout.toolBar.setNavigationOnClickListener { closeScreen() }

        binding.fundRecyclerView.adapter = FundAdapter(this)
    }

    override fun onBackPressed() {
        closeScreen()
    }
}