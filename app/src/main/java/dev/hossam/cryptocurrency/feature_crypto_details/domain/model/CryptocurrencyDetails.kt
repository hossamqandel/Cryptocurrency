package dev.hossam.cryptocurrency.feature_crypto_details.domain.model

import com.google.gson.annotations.SerializedName

data class CryptocurrencyDetails(
    @SerializedName("description")
    val description: String,
    val development_status: String,
    val first_data_at: String,
    val hardware_wallet: Boolean,
    val hash_algorithm: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    val is_new: Boolean,
    val last_data_at: String,
    val links: Links,
    val links_extended: List<LinksExtended>,
    @SerializedName("logo")
    val logo: String,
    val message: String,
    @SerializedName("name")
    val name: String,
    val open_source: Boolean,
    val org_structure: String,
    val proof_type: String,
    @SerializedName("rank")
    val rank: Int,
    val started_at: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("tags")
    val tags: List<Tag>,
    @SerializedName("team")
    val team: List<Team>,
    val type: String,
    val whitepaper: Whitepaper
)

data class Links(
    val explorer: List<String>,
    val facebook: List<String>,
    val reddit: List<String>,
    val source_code: List<String>,
    val website: List<String>,
    val youtube: List<String>
)

data class LinksExtended(
    val stats: Stats,
    val type: String,
    val url: String
)

data class Tag(
    val coin_counter: Int,
    val ico_counter: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)

data class Team(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("position")
    val position: String
)

data class Whitepaper(
    val link: String,
    val thumbnail: String
)

data class Stats(
    val contributors: Int,
    val followers: Int,
    val stars: Int,
    val subscribers: Int
)