package com.plcoding.cryptocurrencyappyt.common

import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

object Utils {

    /*fun Double.round(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return round(this * multiplier) / multiplier
    }*/

    fun roundToTwoDigits(double: Double): Double? {
        // using this Locale because it's the API response format, primarly to avoid locale-dependent parsing issues
        val df = DecimalFormat("#.##", DecimalFormatSymbols(Locale.US))
        df.roundingMode = RoundingMode.DOWN
        val roundOff = df.format(double)
        return try {
            roundOff.toDouble()
        } catch (e: Exception) {
            roundOff.toDoubleOrNull()
        }
    }
}