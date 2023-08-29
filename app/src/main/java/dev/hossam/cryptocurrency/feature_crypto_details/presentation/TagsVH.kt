package dev.hossam.cryptocurrency.feature_crypto_details.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import dev.hossam.cryptocurrency.R

class TagsVH(itemView: View): RecyclerView.ViewHolder(itemView) {

    val tagName: MaterialButton = itemView.findViewById(R.id.btn_Tag)
}