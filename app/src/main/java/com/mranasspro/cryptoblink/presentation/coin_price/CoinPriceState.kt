package com.mranasspro.cryptoblink.presentation.coin_price

import com.mranasspro.cryptoblink.domain.model.CoinPrice

data class CoinPriceState(
    val isLoading: Boolean = false,
    val coinPrice: CoinPrice? = null,
    val error: String = ""
)
