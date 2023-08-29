package dev.hossam.cryptocurrency.feature_crypto_details.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.hossam.cryptocurrency.R

class TeamVH(itemView: View): RecyclerView.ViewHolder(itemView) {

    val memberName: TextView = itemView.findViewById(R.id.tv_MemberName)
    val memberPosition: TextView = itemView.findViewById(R.id.tv_MemberPosition)
}