package com.droidyme.mysoc.ui

import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ActivityAccountStatusBinding
import com.droidyme.mysoc.utility.countDownTimer
import com.droidyme.mysoc.utility.fireIntent
import com.droidyme.mysoc.utility.setTextAnimation


class AccountStatusActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccountStatusBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_account_status)
        init()
    }

    private fun init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            binding.progressBar.indeterminateDrawable.colorFilter =
                BlendModeColorFilter(Color.WHITE, BlendMode.SRC_ATOP)
        } else {
            binding.progressBar.indeterminateDrawable.setColorFilter(
                Color.WHITE,
                PorterDuff.Mode.SRC_ATOP
            )
        }

        countDownTimer(3000) {

            binding.progressBar.visibility = View.GONE
            binding.txtStatus.setTextAnimation("Account created", 300)
            binding.imgCheck.visibility = View.VISIBLE

            countDownTimer(2000) { fireIntent(IntroActivity::class.java, true) }
        }
    }

    override fun onBackPressed() {
    }
}