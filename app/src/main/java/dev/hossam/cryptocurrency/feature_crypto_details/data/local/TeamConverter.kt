package dev.hossam.cryptocurrency.feature_crypto_details.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import dev.hossam.cryptocurrency.feature_crypto_details.data.dto.TeamDTO

class TeamConverter {

    @TypeConverter
    fun toJson(data: List<TeamDTO>) = Gson().toJson(data)
    @TypeConverter
    fun fromJson(value: String) =
        Gson().fromJson(value, Array<TeamDTO>::class.java)
            .toList()
}