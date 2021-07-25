package com.droidyme.mysoc.ui

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.droidyme.mysoc.R
import com.droidyme.mysoc.adapter.IntroSliderAdapter
import com.droidyme.mysoc.model.Slider
import com.droidyme.mysoc.utility.closeScreen
import com.droidyme.mysoc.utility.fireIntent
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        btnRegister.setOnClickListener { fireIntent(RegistrationActivity::class.java) }
        btnLogin.setOnClickListener { fireIntent(LoginActivity::class.java) }
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
        viewPager.adapter = IntroSliderAdapter(this, sliderModels)
        TabLayoutMediator(tabLayout, viewPager, true, true) { tab, position ->
        }.attach()
    }

    override fun onBackPressed() {
        closeScreen()
    }
}