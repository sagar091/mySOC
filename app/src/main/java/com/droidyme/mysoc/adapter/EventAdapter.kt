package com.droidyme.mysoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ItemEventBinding
import com.droidyme.mysoc.ui.EventDetailsActivity
import com.droidyme.mysoc.utility.fireIntent

class EventAdapter(private var context: Context) :
    RecyclerView.Adapter<EventAdapter.CommitteeViewHolder>() {

    inner class CommitteeViewHolder(var binding: ItemEventBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.root.setOnClickListener { context.fireIntent(EventDetailsActivity::class.java) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitteeViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ItemEventBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_event, parent, false)
        return CommitteeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommitteeViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 5
    }
}