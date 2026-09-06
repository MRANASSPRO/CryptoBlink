package com.mranasspro.cryptoblink.data.repository

import com.mranasspro.cryptoblink.data.remote.CoinPaprikaApi
import com.mranasspro.cryptoblink.data.remote.dto.CoinDetailDto
import com.mranasspro.cryptoblink.data.remote.dto.CoinDto
import com.mranasspro.cryptoblink.data.remote.dto.CoinPriceDto
import com.mranasspro.cryptoblink.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

    override suspend fun getCoinPrice(
        baseCurrencyId: String,
        quoteCurrencyId: String?,
        amount: Int?
    ): CoinPriceDto {
        return api.getCoinPrice(baseCurrencyId, quoteCurrencyId ?: "", amount ?: 1)
    }
}