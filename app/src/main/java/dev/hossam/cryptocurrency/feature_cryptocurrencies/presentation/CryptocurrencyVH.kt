package dev.hossam.cryptocurrency.feature_cryptocurrencies.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.hossam.cryptocurrency.R

class CryptocurrencyVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val title: TextView = itemView.findViewById(R.id.cryptocurrencyItem_title)
    val btnView: TextView = itemView.findViewById(R.id.cryptocurrencyItem_BtnView)

}