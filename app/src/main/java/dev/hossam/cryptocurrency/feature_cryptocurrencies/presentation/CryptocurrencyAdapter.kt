package dev.hossam.cryptocurrency.feature_cryptocurrencies.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.request.ImageRequest
import dev.hossam.cryptocurrency.R
import dev.hossam.cryptocurrency.feature_cryptocurrencies.data.dto.CryptocurrencyDTO

class CryptocurrencyAdapter : RecyclerView.Adapter<CryptocurrencyVH>() {

    var data: List<CryptocurrencyDTO>? = null
    var onClick: ((String?) -> Unit)? = null

    fun setList(data: List<CryptocurrencyDTO>?){
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptocurrencyVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cryptocurrency_item, parent, false)
        return CryptocurrencyVH(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: CryptocurrencyVH, position: Int) {
        val currentItem = data?.get(position)

        holder.title.text =
            "$position."
                .plus(" ")
                .plus(currentItem?.cryptoName)
                .plus(" ")
                .plus("(${currentItem?.symbol})")

        currentItem?.isActive?.let { isActive ->
            holder.btnView.text = if (isActive)
                holder.itemView.context.getString(R.string.active) else
                holder.itemView.context.getString(R.string.not_active)
        }

        holder.btnView.setOnClickListener {
            onClick?.invoke(currentItem?.id)
        }
    }



}