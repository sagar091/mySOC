package com.droidyme.mysoc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.droidyme.mysoc.R
import com.droidyme.mysoc.utility.closeScreen
import com.droidyme.mysoc.utility.fireIntent
import kotlinx.android.synthetic.main.activity_view_profile.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class ViewProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_profile)
        init()
    }

    private fun init() {
        toolBar.title = "Profile"
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolBar.setNavigationOnClickListener { closeScreen() }

        actionClick()
    }

    private fun actionClick() {
        txtViewProfile.setOnClickListener { fireIntent(EditProfileActivity::class.java) }
    }

    override fun onBackPressed() {
        closeScreen()
    }
}