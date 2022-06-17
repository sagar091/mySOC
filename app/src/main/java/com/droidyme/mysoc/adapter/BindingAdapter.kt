package com.droidyme.mysoc.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.model.HouseHoldContact
import com.droidyme.mysoc.model.Section

class BindingAdapter {

    companion object {
        @JvmStatic
        @BindingAdapter("loadByRes")
        fun ImageView.loadByRes(icon: Int) {
            setImageResource(icon)
        }

        @JvmStatic
        @BindingAdapter("adapter")
        fun RecyclerView.setAdapter(items: ArrayList<Section.Module>) {
            adapter = ModuleAdapter(this.context, items)
        }

        @JvmStatic
        @BindingAdapter("adapter")
        fun RecyclerView.setHouseHoldAdapter(items: ArrayList<HouseHoldContact>) {
            adapter = HouseHoldServicesAdapter(this.context, items)
        }
    }
}