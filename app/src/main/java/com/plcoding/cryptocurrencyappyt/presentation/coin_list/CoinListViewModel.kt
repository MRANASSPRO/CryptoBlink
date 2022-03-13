package com.plcoding.cryptocurrencyappyt.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    //vmstate shortcut for live template
    private val _coinListstate = mutableStateOf(CoinListState())
    val coinListStateExposed: State<CoinListState> = _coinListstate

    init {
        getCoins()
    }

    private fun getCoins() {
        //call this class like a function since we override the operator function invoke
        getCoinsUseCase().onEach { resultResource ->
            when (resultResource) {
                is Resource.Success -> {
                    _coinListstate.value = CoinListState(
                        coins = resultResource.data
                            ?: emptyList()
                    )
                    _coinListstate.value.coins.onEach { singleCoin ->

                    }
                }
                is Resource.Error -> {
                    _coinListstate.value = CoinListState(
                        error = resultResource.message
                            ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _coinListstate.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope) //launch the flow in a coroutine since flow is async
    }

    //vmstatefunc shortcut for live template
    /*private val _state = mutableStateOf<String>("Initial Value")
    val state: State<String> = _state

    fun setState(value: String) {
        _state.value = value
    }*/

}