package com.droidyme.mysoc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.R

class CircularAdapter : RecyclerView.Adapter<CircularAdapter.CommitteeViewHolder>() {

    class CommitteeViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitteeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_circular, parent, false)
        return CommitteeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommitteeViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 20
    }
}