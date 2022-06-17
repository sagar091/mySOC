package com.droidyme.mysoc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.droidyme.mysoc.R
import com.droidyme.mysoc.adapter.HouseHoldServicesAdapter
import com.droidyme.mysoc.databinding.ActivityHouseHoldServiceBinding
import com.droidyme.mysoc.model.HouseHoldContact
import com.droidyme.mysoc.utility.closeScreen

class HouseHoldServiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHouseHoldServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_house_hold_service)
        init()
    }

    private fun init() {
        binding.toolBarLayout.toolBar.title = "House-hold Services"
        setSupportActionBar(binding.toolBarLayout.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolBarLayout.toolBar.setNavigationOnClickListener { closeScreen() }

        setContacts()
    }

    private fun setContacts() {
        val contacts = arrayListOf<HouseHoldContact>()
        contacts.add(HouseHoldContact("Fabrication", "Abc Xyz", "9429841328", "9429841328"))
        contacts.add(HouseHoldContact("Plumber", "Abc Xyz", "9429841328", "9429841328"))
        contacts.add(HouseHoldContact("Electrician", "Abc Xyz", "9429841328", "9429841328"))
        contacts.add(HouseHoldContact("Furniture", "Abc Xyz", "9429841328", "9429841328"))
        contacts.add(HouseHoldContact("Water Tank Cleaner", "Abc Xyz", "9429841328", "9429841328"))
        contacts.add(HouseHoldContact("School Van", "Abc Xyz", "9429841328", "9429841328"))

        binding.contactRecyclerView.adapter = HouseHoldServicesAdapter(this, contacts)
    }

    override fun onBackPressed() {
        closeScreen()
    }
}