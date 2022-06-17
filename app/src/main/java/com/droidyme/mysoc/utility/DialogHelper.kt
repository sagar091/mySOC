package com.droidyme.mysoc.utility

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.text.TextUtils
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentManager
import com.droidyme.mysoc.fragment.CustomDialogFragment

class DialogHelper {

    companion object {

        private const val TAG: String = "AddMoneyDialog"

        // showing no internet alert
        fun showAlert(
            context: Context?,
            title: String?,
            message: String?,
            btnPositive: String?,
            btnNegative: String?,
            listener: OnOptionListener
        ) {

            val builder = AlertDialog.Builder(
                context!!
            )
            builder.setTitle(title)
            if (!TextUtils.isEmpty(message)) {
                builder.setMessage(message)
            }
            if (!TextUtils.isEmpty(btnPositive)) {
                builder.setPositiveButton(btnPositive) { dialog: DialogInterface, id: Int ->
                    dialog.dismiss()
                    listener.onClick(true)
                }
            }
            if (!TextUtils.isEmpty(btnNegative)) {
                builder.setNegativeButton(btnNegative) { dialog: DialogInterface, id: Int ->
                    // User cancelled the dialog
                    dialog.dismiss()
                    listener.onClick(false)
                }
            }
            val dialog = builder.create()
            dialog.setCancelable(false)
            dialog.setCanceledOnTouchOutside(false)
            dialog.show()
        }

        fun showAlert(context: Context?, message: String?, btnPositive: String?) {
            val builder = AlertDialog.Builder(
                context!!
            )
            if (!TextUtils.isEmpty(message)) {
                builder.setMessage(message)
            }
            if (!TextUtils.isEmpty(btnPositive)) {
                builder.setPositiveButton(btnPositive) { dialog: DialogInterface, id: Int -> dialog.dismiss() }
            }
            val dialog = builder.create()
            dialog.setCancelable(true)
            dialog.setCanceledOnTouchOutside(true)
            dialog.show()
        }

        fun showDialog(
            supportFragmentManager: FragmentManager,
            title: String = "",
            message: String,
            option1: String,
            option2: String = "",
            listener: CustomDialogFragment.OnOptionClickListener
        ) {
            val dialog = CustomDialogFragment.newInstance()
            dialog.setOptionListener(object : CustomDialogFragment.OnOptionClickListener {
                override fun onClick(isYes: Boolean, dialog: Dialog) {
                    listener.onClick(isYes, dialog)
                }
            })
            dialog.set(title, message, option1, option2)
            dialog.show(supportFragmentManager, TAG)
        }

    }

    interface OnOptionListener {
        fun onClick(isYes: Boolean)
    }
}