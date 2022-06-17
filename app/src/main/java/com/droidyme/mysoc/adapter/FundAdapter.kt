package com.droidyme.mysoc.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.droidyme.mysoc.R
import com.droidyme.mysoc.databinding.ItemMonthlyTransactionBinding

class FundAdapter(private var context: Context) :
    RecyclerView.Adapter<FundAdapter.FundViewHolder>() {

    class FundViewHolder(var binding: ItemMonthlyTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            if (adapterPosition % 3 == 0) {
                binding.txtNoTransaction.visibility = View.VISIBLE
                binding.entryLayout.visibility = View.GONE
            } else {
                binding.txtNoTransaction.visibility = View.GONE
                binding.entryLayout.visibility = View.VISIBLE
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FundViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: ItemMonthlyTransactionBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_monthly_transaction, parent, false)
        return FundViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FundViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 20
    }
}