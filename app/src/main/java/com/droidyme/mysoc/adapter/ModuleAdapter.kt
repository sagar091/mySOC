package com.droidyme.mysoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ItemModuleBinding
import com.droidyme.mysoc.model.Section
import com.droidyme.mysoc.ui.*
import com.droidyme.mysoc.utility.fireIntent

class ModuleAdapter(private var context: Context, private var items: ArrayList<Section.Module>) :
    RecyclerView.Adapter<ModuleAdapter.ModuleViewHolder>() {

    inner class ModuleViewHolder(var binding: ItemModuleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(module: Section.Module) {
            binding.txtModuleName.isSelected = true
            binding.executePendingBindings()
            binding.root.setOnClickListener { redirect(module.id) }
        }

        private fun redirect(id: Int) {
            when (id) {
                1 -> context.fireIntent(CircularListActivity::class.java)
                2 -> context.fireIntent(MeetingListActivity::class.java)
                3 -> context.fireIntent(EventListActivity::class.java)
                4 -> context.fireIntent(FundActivity::class.java)
                5 -> context.fireIntent(InHouseBusinessActivity::class.java)
                6 -> context.fireIntent(HouseHoldServiceActivity::class.java)
                7 -> context.fireIntent(RentSellListActivity::class.java)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ItemModuleBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_module, parent, false)
        return ModuleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}