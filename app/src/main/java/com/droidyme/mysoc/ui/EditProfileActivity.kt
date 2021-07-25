package com.droidyme.mysoc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droidyme.mysoc.R
import com.droidyme.mysoc.utility.closeScreen
import kotlinx.android.synthetic.main.layout_toolbar.*

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        init()
    }

    private fun init() {
        toolBar.title = "Edit profile"
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolBar.setNavigationOnClickListener { closeScreen() }
    }

    override fun onBackPressed() {
        closeScreen()
    }
}