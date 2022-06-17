package com.droidyme.mysoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ItemDashboardCommitteeBinding

class HomeCommitteeAdapter(private var context: Context) :
    RecyclerView.Adapter<HomeCommitteeAdapter.CommitteeViewHolder>() {

    inner class CommitteeViewHolder(var binding: ItemDashboardCommitteeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitteeViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ItemDashboardCommitteeBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_dashboard_committee, parent, false)
        return CommitteeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommitteeViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 10
    }
}