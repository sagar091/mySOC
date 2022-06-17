package com.droidyme.mysoc.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.droidyme.mysoc.R
import com.droidyme.mysoc.adapter.RentSellHouseAdapter
import com.droidyme.mysoc.databinding.FragmentRentSellListBinding
import com.droidyme.mysoc.utility.AppConstant


class RentSellListFragment : Fragment() {

    private lateinit var adapter: RentSellHouseAdapter
    private var meetingType: Int = 0
    private lateinit var binding: FragmentRentSellListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_rent_sell_list, container, false)
        init()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(AppConstant.MEETING_POSITION) }?.apply {
            meetingType = getInt(AppConstant.MEETING_POSITION)
        }
    }

    private fun init() {
        adapter = RentSellHouseAdapter(requireContext())
        binding.rentSellRecyclerView.adapter = adapter
    }

    companion object {

        fun newInstance(): RentSellListFragment {
            return RentSellListFragment()
        }
    }
}