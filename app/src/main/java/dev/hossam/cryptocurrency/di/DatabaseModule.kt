package dev.hossam.cryptocurrency.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.hossam.cryptocurrency.core.data.local.CryptocurrencyDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context
    ): Lazy<CryptocurrencyDatabase> = lazy {
            Room.databaseBuilder(
                context = context,
                klass = CryptocurrencyDatabase::class.java,
                name = CryptocurrencyDatabase.DATABASE_NAME
            ).build()
        }
}