package com.droidyme.mysoc.ui

import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ActivityRegistrationBinding
import com.droidyme.mysoc.fragment.CustomDialogFragment
import com.droidyme.mysoc.utility.*

class RegistrationActivity : BaseActivity() {

    private var isShow = false
    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration)
        init()
    }

    private fun init() {
        actionClick()
    }

    private fun actionClick() {
        /*binding.edtType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when {
                    binding.edtType.selectedItem.toString() == "Owned" -> {
                        toast("Owned")
                    }
                    binding.edtType.selectedItem.toString() == "Rental" -> {
                        toast("Rental")
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }*/

        binding.edtDate.setOnClickListener { toast("click") }

        binding.checkShifting.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.dateInput.visibility = View.VISIBLE
            } else {
                binding.dateInput.visibility = View.GONE
            }
        }

        binding.btnRegister.setOnClickListener {
            ProgressUtils.showProgress(this, "Creating an account..")
            countDownTimer(3000) {
                ProgressUtils.hideProgress()
                DialogHelper.showDialog(supportFragmentManager,
                    "Account created",
                    "Your account has been created. You can login into an app once your account will be approved by Admin.",
                    "OK",
                    "",
                    object : CustomDialogFragment.OnOptionClickListener {
                        override fun onClick(isYes: Boolean, dialog: Dialog) {
                            fireIntent(IntroActivity::class.java, true)
                        }
                    })
            }
        }
        binding.txtLoginHere.setOnClickListener {
            fireIntent(LoginActivity::class.java)
            closeScreen()
        }
        /* binding.imgShowPassword.setOnClickListener {
             showHidePassword()
         }*/

        binding.proofInput.setEndIconOnClickListener {
            DialogHelper.showDialog(supportFragmentManager,
                "Property proof",
                getString(R.string.property_proof_tip),
                "OK",
                "",
                object : CustomDialogFragment.OnOptionClickListener {
                    override fun onClick(isYes: Boolean, dialog: Dialog) {
                        dialog.dismiss()
                    }
                })
        }

        binding.edtDate.setOnClickListener { binding.edtDate.setText(Utility.selectDate(this)) }
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