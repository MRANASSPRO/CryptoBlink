package com.mranasspro.cryptoblink.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mranasspro.cryptoblink.common.Resource
import com.mranasspro.cryptoblink.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class CoinListViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase) : ViewModel() {

    private val _coinListState = mutableStateOf(CoinListState())
    val coinListStateExposed: State<CoinListState> = _coinListState

    init {
        getCoins()
    }

    private fun getCoins() {
        // call this class like a function since we override the operator function invoke
        getCoinsUseCase().onEach { resultResource ->
            when (resultResource) {
                is Resource.Success -> {
                    _coinListState.value = CoinListState(
                        coins = resultResource.data
                            ?: emptyList(),
                    )
                    _coinListState.value.coins.onEach { singleCoin ->
                    }
                }
                is Resource.Error -> {
                    _coinListState.value = CoinListState(
                        error = resultResource.message
                            ?: "An unexpected error occurred",
                    )
                }
                is Resource.Loading -> {
                    _coinListState.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope) // launch the flow in a coroutine since flow is async
    }

    // vmstatefunc shortcut for live template
    /*private val _state = mutableStateOf<String>("Initial Value")
    val state: State<String> = _state

    fun setState(value: String) {
        _state.value = value
    }*/
}
