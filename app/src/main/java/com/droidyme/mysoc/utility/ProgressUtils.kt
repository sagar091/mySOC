package com.droidyme.mysoc.utility

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

object ProgressUtils {

    private lateinit var customProgressBar: CustomProgressBar

    fun showProgress(context: Context?, title: String = "Loading") {
        customProgressBar = CustomProgressBar.with(title)
        customProgressBar.show(
            (context as AppCompatActivity).supportFragmentManager,
            CustomProgressBar.TAG
        )
    }

    fun changeText(text: String) {
        if (isProgressVisible()) {
            customProgressBar.changeText(text)
        }
    }

    fun hideProgress() {
        try {
            if (isProgressVisible()) {
                customProgressBar.dismissAllowingStateLoss()
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun isProgressVisible(): Boolean {
        return customProgressBar.isVisible || customProgressBar.isAdded
    }
}