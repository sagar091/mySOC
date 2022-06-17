package com.droidyme.mysoc.ui

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
import android.view.View.OnTouchListener
import androidx.databinding.DataBindingUtil
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ActivityLoginBinding
import com.droidyme.mysoc.utility.closeScreen
import com.droidyme.mysoc.utility.fireIntent
import com.droidyme.mysoc.utility.toast


class LoginActivity : BaseActivity() {

    private var isShow = false
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        init()
    }

    private fun init() {
        actionClick()
    }

    private fun actionClick() {
        binding.txtSignUpHere.setOnClickListener {
            fireIntent(RegistrationActivity::class.java)
            closeScreen()
        }
        binding.btnLogin.setOnClickListener { fireIntent(DashboardActivity::class.java, true) }

        /*binding.edtPassword.setOnTouchListener(OnTouchListener { v, event ->
            val DRAWABLE_LEFT = 0
            val DRAWABLE_TOP = 1
            val DRAWABLE_RIGHT = 2
            val DRAWABLE_BOTTOM = 3
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= binding.edtPassword.right - binding.edtPassword.compoundDrawables
                        .get(DRAWABLE_RIGHT).bounds.width()
                ) {
                    // your action here
                    toast("click")
                    return@OnTouchListener true
                }
            }
            false
        })*/

       /* binding.imgShowPassword.setOnClickListener {
            showHidePassword()
        }*/
        binding.txtForgetPassword.setOnClickListener { fireIntent(ForgetPasswordActivity::class.java) }
    }

    /*private fun showHidePassword() {
        isShow = !isShow
        if (isShow) {
            binding.imgShowPassword.setImageResource(R.drawable.ic_show)
            binding.edtPassword.transformationMethod = null
        } else {
            binding.imgShowPassword.setImageResource(R.drawable.ic_hide)
            binding.edtPassword.transformationMethod = PasswordTransformationMethod()
        }
    }*/

    override fun onBackPressed() {
        closeScreen()
    }
}