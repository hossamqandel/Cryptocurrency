package dev.hossam.cryptocurrency.feature_crypto_details.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.hossam.cryptocurrency.R
import dev.hossam.cryptocurrency.feature_crypto_details.data.dto.TeamDTO
import java.util.Collections

class TeamAdapter : RecyclerView.Adapter<TeamVH>() {

    private var data: List<TeamDTO> = Collections.emptyList()

    fun setList(data: List<TeamDTO>){
        this.data = data
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.team_item, parent, false)
        return TeamVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TeamVH, position: Int) {
        val currentIdx = data[position]
        holder.memberName.text = currentIdx.name
        holder.memberPosition.text = currentIdx.position
    }


}