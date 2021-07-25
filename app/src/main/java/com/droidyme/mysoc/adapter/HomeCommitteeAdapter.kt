package com.droidyme.mysoc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.R

class HomeCommitteeAdapter : RecyclerView.Adapter<HomeCommitteeAdapter.CommitteeViewHolder>() {

    class CommitteeViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitteeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dashboard_committee, parent, false)
        return CommitteeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommitteeViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }
}