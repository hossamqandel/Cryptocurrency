package dev.hossam.cryptocurrency.feature_crypto_details.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.hossam.cryptocurrency.feature_crypto_details.data.dto.TagDTO
import dev.hossam.cryptocurrency.feature_crypto_details.data.dto.TeamDTO

@Entity
data class CryptoDetailsEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val symbol: String,
    val description: String,
    val isActive: Boolean,
    val logo: String,
    val tags: List<TagDTO>,
    val team: List<TeamDTO>
)
