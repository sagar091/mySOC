package com.droidyme.mysoc.ui

import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.droidyme.mysoc.R
import com.droidyme.mysoc.utility.countDownTimer
import com.droidyme.mysoc.utility.fireIntent
import com.droidyme.mysoc.utility.setTextAnimation
import kotlinx.android.synthetic.main.activity_account_status.*


class AccountStatusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_status)
        init()
    }

    private fun init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            progressBar.indeterminateDrawable.colorFilter =
                BlendModeColorFilter(Color.WHITE, BlendMode.SRC_ATOP)
        } else {
            progressBar.indeterminateDrawable.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)
        }

        countDownTimer(3000) {

            progressBar.visibility = View.GONE
            txtStatus.setTextAnimation("Account created", 300)
            imgCheck.visibility = View.VISIBLE

            countDownTimer(2000) { fireIntent(MainActivity::class.java, true) }
        }
    }

    override fun onBackPressed() {
    }
}