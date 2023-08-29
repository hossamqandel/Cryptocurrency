package dev.hossam.cryptocurrency.feature_crypto_details.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import dev.hossam.cryptocurrency.feature_crypto_details.data.dto.TagDTO

class TagConverter {

    @TypeConverter
    fun toJson(data: List<TagDTO>) = Gson().toJson(data)
    @TypeConverter
    fun fromJson(value: String) =
        Gson().fromJson(value, Array<TagDTO>::class.java)
            .toList()
}