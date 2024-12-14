package com.example.daggerhilt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CurrencyAdapter (private val currencies: MutableList<CurrencyModels>) :
    RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    private var onCurrencyClickListener: OnCurrencyClickListener? = null

    interface OnCurrencyClickListener {
        fun onCurrencyClick(currencies: CurrencyModels, position: Int)
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

    override fun getItemCount() = currencies.size

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currency = currencies[position]
        holder.nameCurrency.text = currency.name
        holder.imageCurrency.setImageResource(currency.image)
        holder.itemView.setOnClickListener {
            if (onCurrencyClickListener != null) {
                onCurrencyClickListener!!.onCurrencyClick(currency, position)
            }
        }
    }

    fun setOnCurrencyClickListener(onCurrencyClickListener: OnCurrencyClickListener) {
        this.onCurrencyClickListener = onCurrencyClickListener
    }
}