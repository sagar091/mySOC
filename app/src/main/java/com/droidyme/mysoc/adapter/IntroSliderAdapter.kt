package com.droidyme.mysoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ItemIntroBinding
import com.droidyme.mysoc.model.Slider

class IntroSliderAdapter(
    private var context: Context,
    private var sliderModels: ArrayList<Slider>
) : RecyclerView.Adapter<IntroSliderAdapter.IntroViewHolder>() {

    inner class IntroViewHolder(var binding: ItemIntroBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(slider: Slider) {
            binding.imageView.setImageResource(slider.drawable)
            binding.txtTitle.text = slider.title
            binding.txtContent.text = slider.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ItemIntroBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_intro, parent, false)
        return IntroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        holder.bind(sliderModels[position])
    }

    override fun getItemCount(): Int {
        return sliderModels.size
    }
}