package com.droidyme.mysoc.ui

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.droidyme.mysoc.R
import com.droidyme.mysoc.fragment.HomeFragment
import com.droidyme.mysoc.helper.loadCircular
import com.droidyme.mysoc.utility.fireIntent
import kotlinx.android.synthetic.main.layout_dashboard_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.toolBar

class DashboardActivity : AppCompatActivity() {

    private var option = R.id.action_home
    private var activeFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        init()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dashboard_action_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun init() {
        toolBar.title = ""
        setSupportActionBar(toolBar)
        toolbar_title.text = "Sagar Tahelyani"
        toolbar_sub_title.text = "Volunteer"
        toolbar_app_icon.loadCircular(R.drawable.temp)

        redirectOption()
        actionClick()
    }

    private fun actionClick() {
        layoutProfile.setOnClickListener { fireIntent(ViewProfileActivity::class.java) }
    }

    private fun redirectOption() {
        val manager: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = manager.beginTransaction()
        when (option) {
            R.id.action_home -> {
                activeFragment = HomeFragment.newInstance()
            }
        }
        activeFragment?.let { ft.replace(R.id.frame_container, it, option.toString()) }
        ft.commit()
    }
}