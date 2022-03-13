package com.plcoding.cryptocurrencyappyt.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.common.Constants
import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_coin.GetCoinUseCase
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_coin_price.GetCoinPriceUseCase
import com.plcoding.cryptocurrencyappyt.presentation.coin_price.CoinPriceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

//hiltvm shortcut for live template
@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinUseCase,
    private val getCoinPriceUseCase: GetCoinPriceUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val stateExposed: State<CoinDetailState> = _state

    private val _coinPriceState = mutableStateOf(CoinPriceState())
    val coinPriceStateExposed: State<CoinPriceState> = _coinPriceState

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
            getCorrespondingCoinPrice(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        //call this class like a function since we override the operator function invoke
        getCoinDetailUseCase(coinId).onEach { resultResource ->
            when (resultResource) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(
                        coin = resultResource.data
                    )
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(
                        error = resultResource.message
                            ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope) //launch the flow in a coroutine since flow is async
    }

    private fun getCorrespondingCoinPrice(baseCurrencyId: String) {
        getCoinPriceUseCase(baseCurrencyId).onEach { resultResource ->
            when (resultResource) {
                is Resource.Success -> {
                    _coinPriceState.value = CoinPriceState(
                        coinPrice = resultResource.data
                    )
                }
                is Resource.Error -> {
                    _coinPriceState.value = CoinPriceState(
                        error = resultResource.message
                            ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _coinPriceState.value = CoinPriceState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
        //Timber.d("baseCurrencyId $$baseCurrencyId")
    }
}