package com.droidyme.mysoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ItemCircularBinding
import com.droidyme.mysoc.ui.CircularDetailsActivity
import com.droidyme.mysoc.utility.fireIntent

class CircularAdapter(private var context: Context) :
    RecyclerView.Adapter<CircularAdapter.CommitteeViewHolder>() {

    inner class CommitteeViewHolder(var binding: ItemCircularBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.root.setOnClickListener { context.fireIntent(CircularDetailsActivity::class.java) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitteeViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ItemCircularBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_circular, parent, false)
        return CommitteeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommitteeViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 20
    }
}