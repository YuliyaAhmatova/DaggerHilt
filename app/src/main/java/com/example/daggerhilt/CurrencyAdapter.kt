package com.example.daggerhilt

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class CurrencyAdapter : ListAdapter<CurrencyModels, CurrencyAdapter.CurrencyViewHolder>(CurrencyDiffCallback()) {

    private var onCurrencyClickListener: OnCurrencyClickListener? = null

    interface OnCurrencyClickListener {
        fun onCurrencyClick(currency: CurrencyModels, position: Int)
    }

    class CurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageCurrency: ImageView = itemView.findViewById(R.id.imageCurrency)
        val nameCurrency: TextView = itemView.findViewById(R.id.nameCurrency)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return CurrencyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currency = getItem(position)
        holder.nameCurrency.text = currency.name
        holder.imageCurrency.setImageResource(currency.image)

        holder.itemView.setOnClickListener {
            onCurrencyClickListener?.onCurrencyClick(currency, position)
        }
    }

    fun setOnCurrencyClickListener(listener: OnCurrencyClickListener) {
        this.onCurrencyClickListener = listener
    }
}

class CurrencyDiffCallback : DiffUtil.ItemCallback<CurrencyModels>() {
    override fun areItemsTheSame(oldItem: CurrencyModels, newItem: CurrencyModels) = oldItem.name == newItem.name

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: CurrencyModels, newItem: CurrencyModels) = oldItem == newItem
}