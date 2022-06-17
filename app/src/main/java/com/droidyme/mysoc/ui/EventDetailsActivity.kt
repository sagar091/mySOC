package com.droidyme.mysoc.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ActivityEventDetailsBinding
import com.droidyme.mysoc.utility.closeScreen

class EventDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_event_details)
        init()
    }

    private fun init() {
        binding.toolBarLayout.toolBar.title = ""
        setSupportActionBar(binding.toolBarLayout.toolBar)
        binding.toolBarLayout.toolbarTitle.text = "Ganesh Chaturthi"
        binding.toolBarLayout.toolbarSubTitle.text = "10 Sept, 9.00 AM"
        binding.toolBarLayout.toolbarAppIcon.visibility = View.GONE
        binding.toolBarLayout.imgEmergency.visibility = View.GONE
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolBarLayout.toolBar.setNavigationOnClickListener { closeScreen() }

        actionClick()
    }

    private fun actionClick() {

    }

    override fun onBackPressed() {
        closeScreen()
    }
}