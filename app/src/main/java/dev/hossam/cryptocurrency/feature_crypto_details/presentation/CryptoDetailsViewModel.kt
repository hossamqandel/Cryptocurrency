package dev.hossam.cryptocurrency.feature_crypto_details.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.hossam.cryptocurrency.core.data.util.Resource
import dev.hossam.cryptocurrency.feature_crypto_details.domain.repository.CryptoDetailsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CryptoDetailsViewModel @Inject constructor(
    private val repo: CryptoDetailsRepository,
    val savedStateHandle: SavedStateHandle
): ViewModel() {


    private var coinId: String = ""
    private val _state = MutableStateFlow(CryptoDetailsState())
    val state = _state.asStateFlow()

    init {
        savedStateHandle.get<String>("coinId")?.let { Id ->
            coinId = Id
        }.also {
            getCryptoDetails()
        }

    }
    private fun getCryptoDetails(){
        repo.getCryptoDetailsById(coinId).onEach { resource ->
            when(resource){
                is Resource.Loading -> resource.data?.let { dto ->
                    dto.apply {
                        _state.value = state.value.copy(
                            isLoading = true,
                            name = name,
                            symbol = symbol,
                            description = description,
                            isActive = isActive,
                            tags = tags,
                            team = team
                        )
                    }
                }
                is Resource.Success -> resource.data?.let { dto ->
                    dto.apply {
                        _state.value = state.value.copy(
                            isLoading = false,
                            name = name,
                            symbol = symbol,
                            description = description,
                            isActive = isActive,
                            tags = tags,
                            team = team
                        )
                    }
                }
                is Resource.Error -> resource.data?.let { dto ->
                    dto.apply {
                        _state.value = state.value.copy(
                            isLoading = false,
                            name = name,
                            symbol = symbol,
                            description = description,
                            isActive = isActive,
                            tags = tags,
                            team = team
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
    override fun onCleared() {
        super.onCleared()
    }
}