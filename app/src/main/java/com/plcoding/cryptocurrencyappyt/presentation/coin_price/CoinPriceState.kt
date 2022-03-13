package com.plcoding.cryptocurrencyappyt.presentation.coin_price

import com.plcoding.cryptocurrencyappyt.domain.model.CoinPrice

data class CoinPriceState(
    val isLoading: Boolean = false,
    val coinPrice: CoinPrice? = null,
    val error: String = ""
)
