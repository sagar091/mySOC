package com.droidyme.mysoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.BR
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ItemSectionBinding
import com.droidyme.mysoc.model.Section

class SectionAdapter(private var context: Context, private var items: ArrayList<Section>) :
    RecyclerView.Adapter<SectionAdapter.SectionViewHolder>() {

    inner class SectionViewHolder(var binding: ItemSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(section: Section) {
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ItemSectionBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_section, parent, false)
        return SectionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}