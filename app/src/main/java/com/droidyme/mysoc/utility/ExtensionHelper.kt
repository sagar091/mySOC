package com.droidyme.mysoc.utility

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.text.*
import android.text.style.StyleSpan
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.viewpager2.widget.ViewPager2
import com.droidyme.mysoc.R
import com.droidyme.mysoc.custom.DividerItemDecorator
import com.gun0912.tedpermission.PermissionListener
import java.util.regex.Pattern


private const val EMAIL_PATTERN = ("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")

// to check email id is valid or  not
fun emailNotValid(email: String?): Boolean {
    val pattern = Pattern.compile(EMAIL_PATTERN)
    val matcher = pattern.matcher(email)
    return !matcher.matches()
}

// to show toast
fun Context.toast(message: CharSequence) {
    if (!Utility.isNullOrEmpty(message.toString())) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

// intent function from Activity, clearAll will clean the stack
fun Activity.fireIntent(cls: Class<*>, clearAll: Boolean = false) {
    val i = Intent(this, cls)
    if (clearAll) {
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
    } else {
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    startActivity(i)
    this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
}

// intent function from Context, clearAll will clean the stack
fun Context.fireIntent(cls: Class<*>, clearAll: Boolean = false) {
    val i = Intent(this, cls)
    if (clearAll) {
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
    } else {
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    startActivity(i)
    (this as Activity).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
}

fun Context.fireIntent(cls: Class<*>, clearAll: Boolean = false, bundle: Bundle, key: String) {
    val i = Intent(this, cls)
    if (clearAll) {
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
    } else {
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    i.putExtra(key, bundle)
    startActivity(i)
    (this as Activity).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
}

// finish the screen
fun Activity.closeScreen() {
    this.finish()
    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
}

// get string from EditText
fun EditText.toStr(): String {
    return this.text.toString().trim()
}

// close keyboard
fun Context.closeKeyPad() {
    try {
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        var view: View? = (this as Activity).currentFocus
        if (view == null) {
            view = View(this)
        }
        inputManager.hideSoftInputFromWindow(
            view.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

// screen touch close keyboard
@SuppressLint("ClickableViewAccessibility")
fun setupUI(var0: Context?, var1: View) {
    if (var1 !is EditText) {
        var1.setOnTouchListener { var1, var2 ->
            (var0 as Activity).closeKeyPad()
            false
        }
    }
    if (var1 is ViewGroup) {
        for (var2 in 0 until var1.childCount) {
            setupUI(var0, var1.getChildAt(var2))
        }
    }
}

// for text-watcher for EditText
fun EditText.afterTextChanged(callback: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(
            s: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            callback.invoke(editable.toString())
        }
    })
}

// for EditText done button called
fun EditText.onDone(callback: () -> Unit) {
    imeOptions = EditorInfo.IME_ACTION_DONE // android:imeOptions="actionDone"
    maxLines = 1
    setOnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            callback.invoke()
            true
        }
        false
    }
}

fun countDownTimer(millis: Long, callback: () -> Unit) {
    object : CountDownTimer(millis, 1000) {
        override fun onTick(p0: Long) {

        }

        override fun onFinish() {
            callback.invoke()
        }
    }.start()
}

// for append spans
fun SpannableStringBuilder.spansAppend(
    text: CharSequence,
    flags: Int,
    vararg spans: Any
): SpannableStringBuilder {
    val start = length
    append(text)

    spans.forEach { span ->
        setSpan(span, start, length, flags)
    }

    return this
}

// SpanStyle
fun TextView.setTextWithSpan(
    text: String,
    spanText: String,
    style: StyleSpan?
) {
    val sb = SpannableStringBuilder(text)
    val start = text.indexOf(spanText)
    val end = start + spanText.length
    sb.setSpan(style, start, end, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
    this.text = sb
}

fun AppCompatAutoCompleteTextView.afterTextChanged(callback: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(
            s: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            callback.invoke(editable.toString())
        }
    })
}

fun TextView.setTextAnimation(
    text: String,
    duration: Long = 300,
    completion: (() -> Unit)? = null
) {
    fadOutAnimation(duration) {
        this.text = text
        fadInAnimation(duration) {
            completion?.let {
                it()
            }
        }
    }
}

fun View.fadOutAnimation(
    duration: Long = 300,
    visibility: Int = View.INVISIBLE,
    completion: (() -> Unit)? = null
) {
    animate()
        .alpha(0f)
        .setDuration(duration)
        .withEndAction {
            this.visibility = visibility
            completion?.let {
                it()
            }
        }
}

fun View.fadInAnimation(duration: Long = 300, completion: (() -> Unit)? = null) {
    alpha = 0f
    visibility = View.VISIBLE
    animate()
        .alpha(1f)
        .setDuration(duration)
        .withEndAction {
            completion?.let {
                it()
            }
        }
}

fun RecyclerView.applyDivider(isLastDivider: Boolean) {

    val horizontalDivider =
        ContextCompat.getDrawable(context, R.drawable.divider_horizontal)

    if (isLastDivider) {
        val horizontalDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        horizontalDecoration.setDrawable(horizontalDivider!!)
        addItemDecoration(horizontalDecoration)

    } else {
        val dividerItemDecoration: ItemDecoration =
            DividerItemDecorator(horizontalDivider!!)
        addItemDecoration(dividerItemDecoration)
    }
}

fun Toolbar.setToolbarTextViewsMarquee() {
    for (child in this.children) {
        if (child is TextView) {
            setMarquee(child)
        }
    }
}

fun setMarquee(textView: TextView) {
    textView.ellipsize = TextUtils.TruncateAt.MARQUEE
    textView.isSelected = true
    textView.marqueeRepeatLimit = -1
}


fun ViewPager2.autoScroll(interval: Long) {

    val handler = Handler()
    var scrollPosition = 0

    val runnable = object : Runnable {

        override fun run() {

            /**
             * Calculate "scroll position" with
             * adapter pages count and current
             * value of scrollPosition.
             */
            val count = adapter?.itemCount ?: 0
            setCurrentItem(scrollPosition++ % count, true)

            handler.postDelayed(this, interval)
        }
    }

    registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            scrollPosition = position + 1
        }

    })

    handler.post(runnable)
}

fun Context.call(number: String) {
    Utility.askPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),
        object : PermissionListener {
            override fun onPermissionGranted() {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
                startActivity(intent)
            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {

            }
        })

}

fun Context.whatsApp(number: String) {
    val uri = Uri.parse("smsto:$number")
    val i = Intent(Intent.ACTION_SENDTO, uri)
    i.setPackage("com.whatsapp")
    startActivity(Intent.createChooser(i, ""))
}