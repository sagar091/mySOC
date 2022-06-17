package com.droidyme.mysoc.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droidyme.mysoc.R
import com.droidyme.mysoc.adapter.BusinessGalleryAdapter
import com.droidyme.mysoc.databinding.ActivityBusinessDetailsBinding
import com.droidyme.mysoc.model.BusinessGallery
import com.droidyme.mysoc.utility.*

class BusinessDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBusinessDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_business_details)
        init()
    }

    private fun init() {

        binding.toolBarLayout.toolBar.title = ""
        setSupportActionBar(binding.toolBarLayout.toolBar)
        binding.toolBarLayout.toolbarTitle.text = "Music Classes"
        binding.toolBarLayout.toolbarSubTitle.text = "F-150"
        binding.toolBarLayout.toolbarAppIcon.visibility = View.GONE
        binding.toolBarLayout.imgEmergency.visibility = View.GONE
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolBarLayout.toolBar.setNavigationOnClickListener { closeScreen() }

        initClick()
        initSlider()
    }

    private fun initSlider() {
        val gallery = arrayListOf<BusinessGallery>()
        gallery.add(
            BusinessGallery(
                R.drawable.music1
            )
        )
        gallery.add(
            BusinessGallery(
                R.drawable.music2
            )
        )
        gallery.add(
            BusinessGallery(
                R.drawable.music3
            )
        )
        gallery.add(
            BusinessGallery(
                R.drawable.music4
            )
        )
        binding.gallerySlider.adapter = BusinessGalleryAdapter(this, gallery)
        countDownTimer(3000) {
            binding.gallerySlider.autoScroll(3000)
        }
    }

    private fun initClick() {
        binding.imgCall.setOnClickListener {
            call("9429841328")
        }
        binding.imgWhatsApp.setOnClickListener {
            whatsApp("9429841328")
        }
    }
}