package com.droidyme.mysoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ItemMeetingBinding
import com.droidyme.mysoc.ui.MeetingDetailsActivity
import com.droidyme.mysoc.utility.fireIntent

class MeetingAdapter(var meetingType: Int, private var context: Context) :
    RecyclerView.Adapter<MeetingAdapter.CommitteeViewHolder>() {

    inner class CommitteeViewHolder(var binding: ItemMeetingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.root.setOnClickListener { context.fireIntent(MeetingDetailsActivity::class.java) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitteeViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ItemMeetingBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_meeting, parent, false)
        return CommitteeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommitteeViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 20
    }
}