package com.plcoding.cryptocurrencyappyt.domain.model

data class CoinPrice(
    val amount: Int? = null,
    val baseCurrencyId: String? = "",
    val baseCurrencyName: String? = "",
    val price: Double? = null,
    val quoteCurrencyId: String? = null,
    val quoteCurrencyName: String? = null,
)
