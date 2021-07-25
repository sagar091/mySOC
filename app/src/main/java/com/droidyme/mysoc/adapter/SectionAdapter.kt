package com.droidyme.mysoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.R
import com.droidyme.mysoc.model.Section
import kotlinx.android.synthetic.main.item_section.view.*

class SectionAdapter(var context: Context, private var items: ArrayList<Section>) :
    RecyclerView.Adapter<SectionAdapter.SectionViewHolder>() {

    class SectionViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bind(section: Section) {
            view.txtSectionTitle.text = section.name
            view.moduleRecyclerView.adapter = ModuleAdapter(view.context, section.modules)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_section, parent, false)
        return SectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}