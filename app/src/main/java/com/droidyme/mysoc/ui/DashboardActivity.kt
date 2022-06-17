package com.droidyme.mysoc.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droidyme.mysoc.R
import com.droidyme.mysoc.adapter.SectionAdapter
import com.droidyme.mysoc.databinding.ActivityDashboardBinding
import com.droidyme.mysoc.model.Section
import com.droidyme.mysoc.utility.fireIntent
import com.droidyme.mysoc.utility.loadCircular

class DashboardActivity : AppCompatActivity() {

    private var option = R.id.action_home
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard)
        init()
    }

    private fun init() {
        binding.toolBarLayout.toolBar.title = ""
        setSupportActionBar(binding.toolBarLayout.toolBar)
        binding.toolBarLayout.toolbarTitle.text = "Sagar Tahelyani"
        binding.toolBarLayout.toolbarSubTitle.text = "Volunteer"
        binding.toolBarLayout.toolbarAppIcon.loadCircular(R.drawable.temp)
        binding.toolBarLayout.toolbarAppIcon.visibility = View.VISIBLE
        binding.toolBarLayout.imgEmergency.visibility = View.VISIBLE
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            binding.toolBarLayout.imgEmergency.tooltipText = "Emergency call"
        }

        setDashboard()
        actionClick()
    }

    private fun setDashboard() {
        val sections = arrayListOf<Section>()
        var modules = arrayListOf<Section.Module>()
        var module = Section.Module(1, R.drawable.ic_announcement, "Circular")
        modules.add(module)
        module = Section.Module(2, R.drawable.ic_meeting, "Meetings")
        modules.add(module)
        module = Section.Module(3, R.drawable.ic_events, "Events")
        modules.add(module)
        module = Section.Module(4, R.drawable.ic_fund, "Funds")
        modules.add(module)
        sections.add(Section(1, "Updates", modules))

        modules = arrayListOf()
        module = Section.Module(5, R.drawable.ic_in_house_business, "In-house business")
        modules.add(module)
        module = Section.Module(6, R.drawable.ic_house_hold, "House-hold services")
        modules.add(module)
        module = Section.Module(7, R.drawable.ic_rent_sell, "Rent/Sell")
        modules.add(module)
        module = Section.Module(8, R.drawable.ic_other, "Other")
        modules.add(module)
        sections.add(Section(2, "Services", modules))

        modules = arrayListOf()
        module = Section.Module(9, R.drawable.ic_committee, "Committee members")
        modules.add(module)
        module = Section.Module(10, R.drawable.ic_society, "Society")
        modules.add(module)
        module = Section.Module(11, R.drawable.ic_club_house, "Club house")
        modules.add(module)
        sections.add(Section(3, "About", modules))

        modules = arrayListOf()
        module = Section.Module(12, R.drawable.ic_complaint, "Complaint")
        modules.add(module)
        module = Section.Module(13, R.drawable.ic_suggestion, "Suggestion")
        modules.add(module)
        module = Section.Module(14, R.drawable.ic_polls, "Polls")
        modules.add(module)
        sections.add(Section(4, "Improve your society", modules))

        binding.sectionRecyclerView.adapter = SectionAdapter(this, sections)
    }

    private fun actionClick() {
        binding.toolBarLayout.layoutProfile.setOnClickListener { fireIntent(ViewProfileActivity::class.java) }
        binding.toolBarLayout.imgEmergency.setOnClickListener { fireIntent(ViewProfileActivity::class.java) }
    }
}