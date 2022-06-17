package com.droidyme.mysoc.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droidyme.mysoc.R
import com.droidyme.mysoc.adapter.ConclusionAdapter
import com.droidyme.mysoc.databinding.ActivityMeetingConclusionBinding
import com.droidyme.mysoc.utility.closeScreen
import com.droidyme.mysoc.utility.setToolbarTextViewsMarquee

class MeetingConclusionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMeetingConclusionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_meeting_conclusion)
        init()
    }

    private fun init() {
        binding.toolBarLayout.toolBar.title = "Meeting - 10 SEPT, 9.00 AM"
        binding.toolBarLayout.toolBar.setToolbarTextViewsMarquee()
        setSupportActionBar(binding.toolBarLayout.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolBarLayout.toolBar.setNavigationOnClickListener { onBackPressed() }
        binding.toolBarLayout.imgSingleAction.visibility = View.GONE

        binding.conclusionRecyclerView.adapter = ConclusionAdapter(this)

    }

    override fun onBackPressed() {
        closeScreen()
    }
}