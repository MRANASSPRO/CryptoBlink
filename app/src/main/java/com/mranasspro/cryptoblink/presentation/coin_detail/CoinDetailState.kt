package com.mranasspro.cryptoblink.presentation.coin_detail

import com.mranasspro.cryptoblink.domain.model.CoinDetail

data class CoinDetailState(val isLoading: Boolean = false, val coin: CoinDetail? = null, val error: String = "")
