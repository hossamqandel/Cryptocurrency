package dev.hossam.cryptocurrency.feature_cryptocurrencies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.hossam.cryptocurrency.core.UiEvent
import dev.hossam.cryptocurrency.core.data.util.Resource
import dev.hossam.cryptocurrency.feature_cryptocurrencies.domain.usecase.GetCryptocurrenciesUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.Collections
import javax.inject.Inject

@HiltViewModel
class CryptocurrencyViewModel @Inject constructor(
    private val getCryptocurrenciesUseCase: GetCryptocurrenciesUseCase
): ViewModel() {

    private var getCryptosJob: Job? = null
    private val _state = MutableStateFlow(CryptocurrencyState())
    val state = _state.asStateFlow()

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    init {
        onEvent(orderBy = OrderBy.Descending)
    }

    fun onEvent(orderBy: OrderBy){
        getCryptosJob?.cancel()
        getCryptosJob = getCryptocurrenciesUseCase(orderBy).onEach { resource ->
            when(resource){
                is Resource.Loading -> _state.value = state.value.copy(isLoading = true, cryptocurrencies = resource.data ?: Collections.emptyList())
                is Resource.Success -> _state.value = state.value.copy(isLoading = false, cryptocurrencies = resource.data ?: Collections.emptyList())
                is Resource.Error -> {
                    _state.value = state.value.copy(isLoading = false, cryptocurrencies = resource.data ?: Collections.emptyList())
                    _uiEvent.emit(UiEvent.SnackBar(resource.message ?: ""))
                }
            }
        }.launchIn(viewModelScope)
    }

    override fun onCleared() {
        super.onCleared()
        getCryptosJob?.cancel()
    }
}