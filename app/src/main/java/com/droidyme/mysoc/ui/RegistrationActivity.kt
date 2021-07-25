package com.droidyme.mysoc.ui

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.droidyme.mysoc.R
import com.droidyme.mysoc.utility.closeScreen
import com.droidyme.mysoc.utility.fireIntent
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    private var isShow = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        init()
    }

    private fun init() {
        actionClick()
    }

    private fun actionClick() {
        edtType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when {
                    edtType.selectedItem.toString() == "Owned" -> {
                        txtLabelAttachment.text =
                            "Property proof (electricity-bill | property-index | aadhar-card)"
                    }
                    edtType.selectedItem.toString() == "Rental" -> {
                        txtLabelAttachment.text =
                            "Property proof (Rent agreement, police verification)"
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        btnRegister.setOnClickListener { fireIntent(AccountStatusActivity::class.java) }
        txtLoginHere.setOnClickListener {
            fireIntent(LoginActivity::class.java)
            closeScreen()
        }
        imgShowPassword.setOnClickListener {
            showHidePassword()
        }
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

    override fun onBackPressed() {
        closeScreen()
    }
}