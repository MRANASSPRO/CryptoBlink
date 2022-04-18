package com.plcoding.cryptocurrencyappyt.common

import java.math.RoundingMode
import java.text.DecimalFormat

object Utils {

    /*fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return round(this * multiplier) / multiplier
    }*/

    fun roundToTwoDigits(double: Double): Double? {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val roundOff = df.format(double)
        return try {
            roundOff.toDouble()
        } catch (e: Exception) {
            roundOff.toDoubleOrNull()
        }
    }
}