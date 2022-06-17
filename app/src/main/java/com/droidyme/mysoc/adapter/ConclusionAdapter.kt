package com.droidyme.mysoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ItemMeetingPointConclusionBinding

class ConclusionAdapter(private var context: Context) :
    RecyclerView.Adapter<ConclusionAdapter.PointsViewHolder>() {

    class PointsViewHolder(var binding: ItemMeetingPointConclusionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.txtPoint.text = "Point${adapterPosition + 1}"
            if (adapterPosition % 3 == 0) {
                binding.txtAnswer.text = "MOVED TO NEXT MEETING"
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointsViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ItemMeetingPointConclusionBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_meeting_point_conclusion, parent, false)
        return PointsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PointsViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 5
    }
}