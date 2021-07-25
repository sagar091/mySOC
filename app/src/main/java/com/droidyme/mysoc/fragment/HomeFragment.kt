package com.droidyme.mysoc.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.droidyme.mysoc.R
import com.droidyme.mysoc.adapter.CircularAdapter
import com.droidyme.mysoc.adapter.SectionAdapter
import com.droidyme.mysoc.adapter.HomeCommitteeAdapter
import com.droidyme.mysoc.adapter.UpcomingEventAdapter
import com.droidyme.mysoc.model.Section
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    private lateinit var homeView: View
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeView = inflater.inflate(R.layout.fragment_home, container, false)
        return homeView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        createDashboard()
        homeView.committeeRecyclerView.adapter = HomeCommitteeAdapter()
        homeView.upcomingEventRecyclerView.adapter = UpcomingEventAdapter()
        homeView.announcementRecyclerView.adapter = CircularAdapter()

        layoutManager = LinearLayoutManager(requireContext())

        actionClick()

    }

    private fun createDashboard() {
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
        module = Section.Module(5, R.drawable.ic_in_house_business, "In-house Business")
        modules.add(module)
        module = Section.Module(6, R.drawable.ic_house_hold, "House-hold Services")
        modules.add(module)
        module = Section.Module(7, R.drawable.ic_rent_sell, "Rent/Sell")
        modules.add(module)
        module = Section.Module(8, R.drawable.ic_other, "Other")
        modules.add(module)
        sections.add(Section(2, "Services", modules))

        modules = arrayListOf()
        module = Section.Module(9, R.drawable.ic_committee, "Committee Members")
        modules.add(module)
        module = Section.Module(10, R.drawable.ic_society, "Society")
        modules.add(module)
        module = Section.Module(11, R.drawable.ic_club_house, "Club House")
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

        sectionRecyclerView.adapter = SectionAdapter(requireContext(), sections)
    }

    private fun actionClick() {
        /*homeView.txtViewProfile.setOnClickListener {
            requireActivity().fireIntent(
                EditProfileActivity::class.java
            )
        }*/
    }

    companion object {
        fun newInstance(): HomeFragment {
            val args = Bundle()

            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }
}