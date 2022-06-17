package com.droidyme.mysoc.fragment

import android.app.Dialog
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.DialogCustomBinding

class CustomDialogFragment : DialogFragment() {

    private lateinit var binding: DialogCustomBinding
    private lateinit var listener: OnOptionClickListener

    private var title: String = ""
    private var message: String = ""
    private var option1: String = ""
    private var option2: String = ""

    companion object {
        fun newInstance(): CustomDialogFragment {
            val args = Bundle()

            val fragment = CustomDialogFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_custom, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
    }

    private fun setUpView() {
        if (TextUtils.isEmpty(title)) {
            binding.txtTitle.visibility = View.GONE
        } else {
            binding.txtTitle.visibility = View.VISIBLE
            binding.txtTitle.text = title
        }
        binding.txtMessage.text = message
        binding.txtOption1.text = option1
        if (TextUtils.isEmpty(option2)) {
            binding.txtOption2.visibility = View.GONE
        } else {
            binding.txtOption2.visibility = View.VISIBLE
            binding.txtOption2.text = option2
        }

        binding.txtOption1.setOnClickListener { dialog?.let { it1 -> listener.onClick(true, it1) } }
        binding.txtOption2.setOnClickListener {
            dialog?.let { it1 ->
                listener.onClick(
                    false,
                    it1
                )
            }
        }
    }

    fun set(title: String, message: String, option1: String, option2: String) {
        this.title = title
        this.message = message
        this.option1 = option1
        this.option2 = option2
    }

    fun setOptionListener(listenerCB: OnOptionClickListener) {
        this.listener = listenerCB
    }

    interface OnOptionClickListener {
        fun onClick(isYes: Boolean, dialog: Dialog)
    }
}