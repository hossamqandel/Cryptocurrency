package dev.hossam.cryptocurrency.feature_crypto_details.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.hossam.cryptocurrency.R
import dev.hossam.cryptocurrency.feature_crypto_details.data.dto.TagDTO
import java.util.Collections

class TagsAdapter : RecyclerView.Adapter<TagsVH>() {

    private var data: List<TagDTO> = Collections.emptyList()

    fun setList(data: List<TagDTO>) {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tag_item, parent, false)
        return TagsVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TagsVH, position: Int) {
        val currentIdx = data[position]
        holder.tagName.text = currentIdx.name
    }
}