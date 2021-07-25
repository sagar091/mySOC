package com.droidyme.mysoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.R
import com.droidyme.mysoc.model.Slider
import kotlinx.android.synthetic.main.item_intro.view.*

class IntroSliderAdapter(
    private var context: Context,
    private var sliderModels: ArrayList<Slider>
) : RecyclerView.Adapter<IntroSliderAdapter.IntroViewHolder>() {

    class IntroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(slider: Slider) {
            itemView.imageView.setImageResource(slider.drawable)
            itemView.txtTitle.text = slider.title
            itemView.txtContent.text = slider.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_intro, parent, false)
        return IntroViewHolder(view)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        holder.bind(sliderModels[position])
    }

    override fun getItemCount(): Int {
        return sliderModels.size
    }
}