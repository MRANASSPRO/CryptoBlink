package com.plcoding.cryptocurrencyappyt.domain.model

data class Coin(
    val id: String? = "",
    val isActive: Boolean? = null,
    val name: String? = "",
    val rank: Int? = null,
    val symbol: String? = ""
)
