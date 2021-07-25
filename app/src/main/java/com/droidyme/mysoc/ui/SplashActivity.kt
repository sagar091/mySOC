package com.droidyme.mysoc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droidyme.mysoc.R
import com.droidyme.mysoc.utility.countDownTimer
import com.droidyme.mysoc.utility.fireIntent

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        countDownTimer(1000) { fireIntent(MainActivity::class.java, true) }
    }
}