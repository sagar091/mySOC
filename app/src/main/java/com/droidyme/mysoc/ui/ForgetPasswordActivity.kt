package com.droidyme.mysoc.ui

import android.app.Dialog
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ActivityForgotPasswordBinding
import com.droidyme.mysoc.fragment.CustomDialogFragment
import com.droidyme.mysoc.utility.DialogHelper
import com.droidyme.mysoc.utility.ProgressUtils
import com.droidyme.mysoc.utility.closeScreen
import com.droidyme.mysoc.utility.countDownTimer

class ForgetPasswordActivity : BaseActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_forgot_password)
        init()
    }

    private fun init() {
        actionClick()
    }

    private fun actionClick() {
        binding.btnReset.setOnClickListener {
            ProgressUtils.showProgress(this, "Sending password reset link..")
            countDownTimer(3000) {
                ProgressUtils.hideProgress()
                DialogHelper.showDialog(supportFragmentManager,
                    "",
                    "We have sent password reset link. Please check",
                    "OK",
                    "",
                    object : CustomDialogFragment.OnOptionClickListener {
                        override fun onClick(isYes: Boolean, dialog: Dialog) {
                            dialog.dismiss()
                            closeScreen()
                        }
                    })
            }
        }
    }

    override fun onBackPressed() {
        closeScreen()
    }
}