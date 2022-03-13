package com.plcoding.cryptocurrencyappyt.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.plcoding.cryptocurrencyappyt.domain.model.CoinPrice

data class CoinPriceDto(
    val amount: Int,
    @SerializedName("base_currency_id")
    val baseCurrencyId: String,
    @SerializedName("base_currency_name")
    val baseCurrencyName: String,
    @SerializedName("base_price_last_updated")
    val basePriceLastUpdated: String,
    val price: Double,
    @SerializedName("quote_currency_id")
    val quoteCurrencyId: String,
    @SerializedName("quote_currency_name")
    val quoteCurrencyName: String,
    @SerializedName("quote_price_last_updated")
    val quotePriceLastUpdated: String
)

fun CoinPriceDto.toCoinPrice(): CoinPrice {
    return CoinPrice(
        amount = amount,
        baseCurrencyId = baseCurrencyId,
        baseCurrencyName = baseCurrencyName,
        price = price,
        quoteCurrencyId = quoteCurrencyId,
        quoteCurrencyName = quoteCurrencyName
    )
}