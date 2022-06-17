package com.droidyme.mysoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ItemGalleryBinding
import com.droidyme.mysoc.model.BusinessGallery

class BusinessGalleryAdapter(
    private var context: Context,
    private var sliderModels: ArrayList<BusinessGallery>
) : RecyclerView.Adapter<BusinessGalleryAdapter.GalleryViewHolder>() {

    inner class GalleryViewHolder(var binding: ItemGalleryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(slider: BusinessGallery) {
            binding.imageView.setImageResource(slider.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ItemGalleryBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_gallery, parent, false)
        return GalleryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(sliderModels[position])
    }

    override fun getItemCount(): Int {
        return sliderModels.size
    }
}