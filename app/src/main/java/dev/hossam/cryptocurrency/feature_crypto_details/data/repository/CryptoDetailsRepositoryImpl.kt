package dev.hossam.cryptocurrency.feature_crypto_details.data.repository

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.hossam.cryptocurrency.R
import dev.hossam.cryptocurrency.core.data.remote.CryptocurrencyService
import dev.hossam.cryptocurrency.core.data.util.Resource
import dev.hossam.cryptocurrency.feature_crypto_details.data.dto.CryptocurrencyDetailsDTO
import dev.hossam.cryptocurrency.feature_crypto_details.data.local.CryptoDetailsDao
import dev.hossam.cryptocurrency.feature_crypto_details.data.mapper.responseToCryptoDetailsDTO
import dev.hossam.cryptocurrency.feature_crypto_details.data.mapper.toCryptoDetailsDTO
import dev.hossam.cryptocurrency.feature_crypto_details.data.mapper.toCryptoDetailsEntity
import dev.hossam.cryptocurrency.feature_crypto_details.domain.repository.CryptoDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class CryptoDetailsRepositoryImpl @Inject constructor(
    @ApplicationContext val context: Context,
    private val api: CryptocurrencyService,
    private val dao: CryptoDetailsDao
) : CryptoDetailsRepository {
    override fun getCryptoDetailsById(id: String): Flow<Resource<CryptocurrencyDetailsDTO>> = flow {
        emit(Resource.Loading())
        val oldCrypto = dao.getCryptoDetails(id)?.toCryptoDetailsDTO()
        emit(Resource.Loading(data = oldCrypto))

        try {
            val newCrypto = api.getCryptoDetails(id).responseToCryptoDetailsDTO()
            dao.insertCrypto(newCrypto.toCryptoDetailsEntity())
        } catch (e: IOException){
            emit(Resource.Error(
                message = context.getString(R.string.io_exception),
                data = oldCrypto
            ))
        } catch (e: HttpException){
            emit(Resource.Error(
                message = context.getString(R.string.http_exception),
                data = oldCrypto
            ))
        }
        val latestCrypto = dao.getCryptoDetails(id)?.toCryptoDetailsDTO()
        emit(Resource.Success(latestCrypto!!))
    }
}