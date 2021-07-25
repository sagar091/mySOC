package com.droidyme.mysoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.R
import com.droidyme.mysoc.model.Section
import com.droidyme.mysoc.ui.CircularActivity
import com.droidyme.mysoc.utility.fireIntent
import kotlinx.android.synthetic.main.item_module.view.*

class ModuleAdapter(var context: Context, private var items: ArrayList<Section.Module>) :
    RecyclerView.Adapter<ModuleAdapter.ModuleViewHolder>() {

    class ModuleViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bind(module: Section.Module) {
            view.txtModuleName.text = module.name
            view.txtModuleName.isSelected = true
            view.imgModuleIcon.setImageResource(module.icon)
            view.setOnClickListener { redirect(module.id) }
        }

        private fun redirect(id: Int) {
            when (id) {
                1 -> view.context.fireIntent(CircularActivity::class.java)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_module, parent, false)
        return ModuleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}