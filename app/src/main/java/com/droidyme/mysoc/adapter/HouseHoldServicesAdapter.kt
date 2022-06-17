package com.droidyme.mysoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.BR
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ItemHouseHoldBinding
import com.droidyme.mysoc.model.HouseHoldContact
import com.droidyme.mysoc.utility.call
import com.droidyme.mysoc.utility.whatsApp

class HouseHoldServicesAdapter(
    private var context: Context,
    private var items: ArrayList<HouseHoldContact>
) :
    RecyclerView.Adapter<HouseHoldServicesAdapter.HouseHoldServicesViewHolder>() {

    inner class HouseHoldServicesViewHolder(var binding: ItemHouseHoldBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(houseHoldContact: HouseHoldContact) {
            binding.setVariable(BR.contact, houseHoldContact)
            binding.executePendingBindings()

            binding.imgCall.setOnClickListener { context.call(houseHoldContact.contact) }
            binding.imgWhatsApp.setOnClickListener { context.whatsApp(houseHoldContact.whatsapp) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HouseHoldServicesViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ItemHouseHoldBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_house_hold, parent, false)
        return HouseHoldServicesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HouseHoldServicesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}