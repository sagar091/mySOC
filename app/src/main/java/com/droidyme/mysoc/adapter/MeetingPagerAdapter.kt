package com.droidyme.mysoc.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.droidyme.mysoc.fragment.MeetingListFragment
import com.droidyme.mysoc.utility.AppConstant

class MeetingPagerAdapter(context: FragmentActivity) : FragmentStateAdapter(context) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int)
        val fragment = MeetingListFragment()
        fragment.arguments = Bundle().apply {
            // Our object is just an integer :-P
            putInt(AppConstant.MEETING_POSITION, position)
        }
        return fragment
    }
}