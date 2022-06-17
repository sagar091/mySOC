package com.droidyme.mysoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ItemMeetingPointBinding

class MeetingPointsAdapter(private var context: Context) :
    RecyclerView.Adapter<MeetingPointsAdapter.PointsViewHolder>() {

    class PointsViewHolder(var binding: ItemMeetingPointBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.txtPoint.text = "Point${adapterPosition + 1}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointsViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ItemMeetingPointBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_meeting_point, parent, false)
        return PointsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PointsViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 5
    }
}