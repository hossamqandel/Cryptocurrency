package dev.hossam.cryptocurrency.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.hossam.cryptocurrency.core.constant.Const

@Database(exportSchema = false, version = Const.RoomUtil.VERSION)
abstract class CryptocurrencyDatabase : RoomDatabase() {

}