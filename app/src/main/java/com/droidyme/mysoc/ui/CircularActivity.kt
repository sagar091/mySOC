package com.droidyme.mysoc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droidyme.mysoc.R
import com.droidyme.mysoc.adapter.CircularAdapter
import com.droidyme.mysoc.utility.applyDivider
import com.droidyme.mysoc.utility.closeScreen
import kotlinx.android.synthetic.main.activity_circular.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class CircularActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circular)
        init()
    }

    private fun init(){
        toolBar.title = "Circular"
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolBar.setNavigationOnClickListener { closeScreen() }

        circularRecyclerView.adapter = CircularAdapter()
        circularRecyclerView.applyDivider(false)
    }

    override fun onBackPressed() {
        closeScreen()
    }
}