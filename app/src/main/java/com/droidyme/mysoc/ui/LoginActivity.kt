package com.droidyme.mysoc.ui

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import androidx.appcompat.app.AppCompatActivity
import com.droidyme.mysoc.R
import com.droidyme.mysoc.utility.closeScreen
import com.droidyme.mysoc.utility.fireIntent
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var isShow = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }

    private fun init() {
        actionClick()
    }

    private fun actionClick() {
        txtSignUpHere.setOnClickListener {
            fireIntent(RegistrationActivity::class.java)
            closeScreen()
        }
        btnLogin.setOnClickListener { fireIntent(DashboardActivity::class.java, true) }
        imgShowPassword.setOnClickListener {
            showHidePassword()
        }
        txtForgetPassword.setOnClickListener { fireIntent(ForgetPasswordActivity::class.java) }
    }

    private fun showHidePassword() {
        isShow = !isShow
        if (isShow) {
            imgShowPassword.setImageResource(R.drawable.ic_show)
            edtPassword.transformationMethod = null
        } else {
            imgShowPassword.setImageResource(R.drawable.ic_hide)
            edtPassword.transformationMethod = PasswordTransformationMethod()
        }
    }
}