package com.droidyme.mysoc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droidyme.mysoc.R
import com.droidyme.mysoc.adapter.EventAdapter
import com.droidyme.mysoc.databinding.ActivityEventListBinding
import com.droidyme.mysoc.utility.closeScreen

class EventListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_event_list)
        init()
    }

    private fun init() {
        binding.toolBarLayout.toolBar.title = "Events"
        setSupportActionBar(binding.toolBarLayout.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolBarLayout.toolBar.setNavigationOnClickListener { closeScreen() }

        binding.eventRecyclerView.adapter = EventAdapter(this)
    }

    override fun onBackPressed() {
        closeScreen()
    }
}