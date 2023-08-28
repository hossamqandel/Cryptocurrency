package dev.hossam.cryptocurrency.feature_cryptocurrencies.data.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.hossam.cryptocurrency.R
import dev.hossam.cryptocurrency.core.data.remote.CryptocurrencyService
import dev.hossam.cryptocurrency.core.data.util.Resource
import dev.hossam.cryptocurrency.feature_cryptocurrencies.data.dto.CryptocurrencyDTO
import dev.hossam.cryptocurrency.feature_cryptocurrencies.data.local.CryptocurrencyDao
import dev.hossam.cryptocurrency.feature_cryptocurrencies.data.mapper.responseToCryptocurrencyDTO
import dev.hossam.cryptocurrency.feature_cryptocurrencies.data.mapper.toCryptocurrenciesDTO
import dev.hossam.cryptocurrency.feature_cryptocurrencies.data.mapper.toCryptocurrenciesEntity
import dev.hossam.cryptocurrency.feature_cryptocurrencies.domain.repository.CryptocurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CryptocurrencyRepositoryImpl @Inject constructor(
    @ApplicationContext val context: Context,
    private val api: CryptocurrencyService,
    private val dao: CryptocurrencyDao
) : CryptocurrencyRepository {

    override fun getAllCryptocurrencies(): Flow<Resource<List<CryptocurrencyDTO>>> = flow {
        emit(Resource.Loading())
        val oldCryptocurrencies = dao.getAllCryptocurrencies().toCryptocurrenciesDTO()
        emit(Resource.Loading(oldCryptocurrencies))

        try {
            val remoteCryptocurrencies = api.getAllCryptocurrencies().map { it.responseToCryptocurrencyDTO() }
            dao.deleteAllCryptocurrencies()
            dao.insertCryptocurrencies(remoteCryptocurrencies.toCryptocurrenciesEntity())
            val latestCryptocurrencies = dao.getAllCryptocurrencies()
            emit(Resource.Success(latestCryptocurrencies.toCryptocurrenciesDTO()))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = context.getString(R.string.io_exception),
                data = oldCryptocurrencies
            )
            )
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = context.getString(R.string.http_exception),
                data = oldCryptocurrencies
            )
            )
        }

    }
}