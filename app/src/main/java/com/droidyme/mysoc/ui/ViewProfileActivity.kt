package com.droidyme.mysoc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ActivityViewProfileBinding
import com.droidyme.mysoc.utility.closeScreen
import com.droidyme.mysoc.utility.fireIntent

class ViewProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_profile)
        init()
    }

    private fun init() {
        binding.toolBarLayout.toolBar.title = "Profile"
        setSupportActionBar(binding.toolBarLayout.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolBarLayout.toolBar.setNavigationOnClickListener { closeScreen() }

        actionClick()
    }

    private fun actionClick() {
        binding.txtEditProfile.setOnClickListener { fireIntent(EditProfileActivity::class.java) }
    }

    override fun onBackPressed() {
        closeScreen()
    }
}