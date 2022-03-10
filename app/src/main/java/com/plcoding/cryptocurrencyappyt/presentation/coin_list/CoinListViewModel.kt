package com.plcoding.cryptocurrencyappyt.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

//hiltvm shortcut for live template
@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    //vmstate shortcut for live template
    private val _state = mutableStateOf(CoinListState())
    val stateExposed: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        //call this class like a function since we override the operator function invoke
        getCoinsUseCase().onEach { resultResource ->
            when (resultResource) {
                is Resource.Success -> {
                    _state.value = CoinListState(
                        coins = resultResource.data
                            ?: emptyList()
                    )
                }
                is Resource.Error -> {
                    _state.value = CoinListState(
                        error = resultResource.message
                            ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
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