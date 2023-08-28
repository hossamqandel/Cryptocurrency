package dev.hossam.cryptocurrency.feature_cryptocurrencies.domain.usecase

import dev.hossam.cryptocurrency.core.data.util.Resource
import dev.hossam.cryptocurrency.feature_cryptocurrencies.data.dto.CryptocurrencyDTO
import dev.hossam.cryptocurrency.feature_cryptocurrencies.domain.repository.CryptocurrencyRepository
import dev.hossam.cryptocurrency.feature_cryptocurrencies.presentation.OrderBy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Collections
import javax.inject.Inject

class GetCryptocurrenciesUseCase @Inject constructor(
    private val repo: CryptocurrencyRepository
) {

    operator fun invoke(orderBy: OrderBy): Flow<Resource<List<CryptocurrencyDTO>>> {
        return repo.getAllCryptocurrencies().map { resource ->
            when (resource) {
                is Resource.Loading -> when (orderBy) {

                    is OrderBy.Descending -> Resource.Loading(
                        resource.data?.sortedByDescending { cryptocurrencyDto -> cryptocurrencyDto.id }
                    )

                    is OrderBy.Ascending -> Resource.Loading(
                        resource.data?.sortedBy { cryptocurrencyDto -> cryptocurrencyDto.id }
                    )
                }


                is Resource.Success -> when (orderBy) {
                    is OrderBy.Descending -> Resource.Success(
                        resource.data?.sortedByDescending { cryptocurrencyDto ->
                            cryptocurrencyDto.id
                        } ?: Collections.emptyList()
                    )

                    is OrderBy.Ascending -> Resource.Success(
                        resource.data?.sortedBy { cryptocurrencyDto ->
                            cryptocurrencyDto.id
                        } ?: Collections.emptyList()
                    )
                }


                is Resource.Error -> when (orderBy) {
                    is OrderBy.Descending -> Resource.Error(
                        message = resource.message!!,
                        data = resource.data!!.sortedByDescending { cryptocurrencyDto -> cryptocurrencyDto.id }
                    )

                    is OrderBy.Ascending -> Resource.Error(
                        message = resource.message!!,
                        data = resource.data!!.sortedBy { cryptocurrencyDto -> cryptocurrencyDto.id }
                    )
                }
            }
        }
    }
}