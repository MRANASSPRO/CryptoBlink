package com.plcoding.cryptocurrencyappyt.common

import kotlin.math.round

object Utils {

    fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return round(this * multiplier) / multiplier
    }
}