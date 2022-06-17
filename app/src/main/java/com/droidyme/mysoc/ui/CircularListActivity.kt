package com.droidyme.mysoc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droidyme.mysoc.R
import com.droidyme.mysoc.adapter.CircularAdapter
import com.droidyme.mysoc.databinding.ActivityCircularListBinding
import com.droidyme.mysoc.utility.closeScreen

class CircularListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCircularListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_circular_list)
        init()
    }

    private fun init() {
        binding.toolBarLayout.toolBar.title = "Circular"
        setSupportActionBar(binding.toolBarLayout.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolBarLayout.toolBar.setNavigationOnClickListener { closeScreen() }

        binding.circularRecyclerView.adapter = CircularAdapter(this)
    }

    override fun onBackPressed() {
        closeScreen()
    }
}