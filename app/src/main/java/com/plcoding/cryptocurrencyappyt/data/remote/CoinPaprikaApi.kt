package com.plcoding.cryptocurrencyappyt.data.remote

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinPriceDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    //with a path parameter
    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

    //api.coinpaprika.com/v1/price-converter?base_currency_id=btc-bitcoin&quote_currency_id=usd-us-dollars&amount=1
    @GET("v1/price-converter")
    suspend fun getCoinPrice(
        @Query("base_currency_id") baseCurrencyId: String,
        @Query("quote_currency_id") quoteCurrencyId: String,
        @Query("amount") amount: Int
    ): CoinPriceDto
}