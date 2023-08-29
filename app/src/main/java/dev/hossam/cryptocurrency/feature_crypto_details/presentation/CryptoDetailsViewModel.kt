package dev.hossam.cryptocurrency.feature_crypto_details.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.hossam.cryptocurrency.feature_crypto_details.domain.repository.CryptoDetailsRepository
import javax.inject.Inject

@HiltViewModel
class CryptoDetailsViewModel @Inject constructor(
    private val repo: CryptoDetailsRepository
): ViewModel() {



    override fun onCleared() {
        super.onCleared()
    }
}