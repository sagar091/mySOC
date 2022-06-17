package com.droidyme.mysoc.ui

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droidyme.mysoc.R
import com.droidyme.mysoc.adapter.IntroSliderAdapter
import com.droidyme.mysoc.databinding.ActivityMainBinding
import com.droidyme.mysoc.model.Slider
import com.droidyme.mysoc.utility.closeScreen
import com.droidyme.mysoc.utility.fireIntent
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
    }

    private fun init() {
        binding.txtRegister.setOnClickListener { fireIntent(RegistrationActivity::class.java) }
        binding.txtLogin.setOnClickListener { fireIntent(LoginActivity::class.java) }
        initPager()
    }

    private fun initPager() {
        val sliderModels = arrayListOf<Slider>()
        sliderModels.add(
            Slider(
                R.drawable.ic_email,
                getString(R.string.slide_1_title),
                getString(R.string.dummy)
            )
        )
        sliderModels.add(
            Slider(
                R.drawable.ic_calendar,
                getString(R.string.slide_2_title),
                getString(R.string.dummy)
            )
        )
        sliderModels.add(
            Slider(
                R.drawable.ic_shopping,
                getString(R.string.slide_3_title),
                getString(R.string.dummy)
            )
        )
        sliderModels.add(
            Slider(
                R.drawable.ic_social,
                getString(R.string.slide_4_title),
                getString(R.string.dummy)
            )
        )
        binding.viewPager.adapter = IntroSliderAdapter(this, sliderModels)
        TabLayoutMediator(binding.tabLayout, binding.viewPager, true, true) { tab, position ->
        }.attach()
    }

    override fun onBackPressed() {
        closeScreen()
    }
}