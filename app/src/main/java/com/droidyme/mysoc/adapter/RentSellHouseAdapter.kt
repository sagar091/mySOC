package com.droidyme.mysoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ItemRentSellHouseBinding
import com.droidyme.mysoc.ui.BusinessDetailsActivity
import com.droidyme.mysoc.utility.fireIntent

class RentSellHouseAdapter(private var context: Context) :
    RecyclerView.Adapter<RentSellHouseAdapter.RentSellViewHolder>() {

    inner class RentSellViewHolder(var binding: ItemRentSellHouseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.root.setOnClickListener {
                context.fireIntent(BusinessDetailsActivity::class.java, false)
//                val detailsDialog = BusinessDetailsDialog.newInstance()
//                detailsDialog.show((context as AppCompatActivity).supportFragmentManager, "details")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RentSellViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ItemRentSellHouseBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_rent_sell_house, parent, false)
        return RentSellViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RentSellViewHolder, position: Int) {
        holder.bind()

    }

    override fun getItemCount(): Int {
        return 20
    }
}