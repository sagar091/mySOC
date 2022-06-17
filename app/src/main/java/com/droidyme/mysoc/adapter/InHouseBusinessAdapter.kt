package com.droidyme.mysoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ItemInHouseBusinessBinding
import com.droidyme.mysoc.ui.BusinessDetailsActivity
import com.droidyme.mysoc.utility.fireIntent

class InHouseBusinessAdapter(private var context: Context) :
    RecyclerView.Adapter<InHouseBusinessAdapter.BusinessViewHolder>() {

    inner class BusinessViewHolder(var binding: ItemInHouseBusinessBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.root.setOnClickListener {
                context.fireIntent(BusinessDetailsActivity::class.java, false)
//                val detailsDialog = BusinessDetailsDialog.newInstance()
//                detailsDialog.show((context as AppCompatActivity).supportFragmentManager, "details")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ItemInHouseBusinessBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_in_house_business, parent, false)
        return BusinessViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BusinessViewHolder, position: Int) {
        holder.bind()

    }

    override fun getItemCount(): Int {
        return 20
    }
}