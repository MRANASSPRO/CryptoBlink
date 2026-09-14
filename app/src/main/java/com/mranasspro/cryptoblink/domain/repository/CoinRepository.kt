package com.mranasspro.cryptoblink.domain.repository

import com.mranasspro.cryptoblink.data.remote.dto.CoinDetailDto
import com.mranasspro.cryptoblink.data.remote.dto.CoinDto
import com.mranasspro.cryptoblink.data.remote.dto.CoinPriceDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

    suspend fun getCoinPrice(
        baseCurrencyId: String,
        quoteCurrencyId: String? = "usd-us-dollars",
        amount: Int? = 1,
    ): CoinPriceDto
}
