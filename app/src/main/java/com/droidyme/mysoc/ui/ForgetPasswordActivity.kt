package com.droidyme.mysoc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droidyme.mysoc.R
import com.droidyme.mysoc.utility.closeScreen
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgetPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        init()
    }

    private fun init() {
        actionClick()
    }

    private fun actionClick() {
        btnReset.setOnClickListener { closeScreen() }
    }

    override fun onBackPressed() {
        closeScreen()
    }
}