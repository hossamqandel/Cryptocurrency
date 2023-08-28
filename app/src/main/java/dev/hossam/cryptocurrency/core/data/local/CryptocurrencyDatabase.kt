package dev.hossam.cryptocurrency.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(exportSchema = false, version = 1)
abstract class CryptocurrencyDatabase : RoomDatabase() {

    companion object { const val DATABASE_NAME = "Cryptocurrency_Database" }

}