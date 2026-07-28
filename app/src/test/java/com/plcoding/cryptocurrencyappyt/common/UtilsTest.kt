package com.plcoding.cryptocurrencyappyt.common

import com.plcoding.cryptocurrencyappyt.common.Utils.roundToTwoDigits
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.Locale

class UtilsTest {

    private lateinit var defaultLocale: Locale

    @Before
    fun setUp() {
        defaultLocale = Locale.getDefault()
    }

    @After
    fun tearDown() {
        Locale.setDefault(defaultLocale)
    }

    @Test
    fun `roundToTwoDigits truncates to two decimals under US locale`() {
        Locale.setDefault(Locale.US)
        assertEquals(1234.56, roundToTwoDigits(1234.5678))
    }

    @Test
    fun `roundToTwoDigits is locale-independent for comma-decimal locales`() {
        // German locale formats numbers with a comma decimal separator by default.
        // The bug: DecimalFormat("#.##") without explicit symbols used the comma,
        // then String.toDouble()/toDoubleOrNull() (which require a dot) failed to
        // parse it and coinPrice silently became null.
        Locale.setDefault(Locale.GERMANY)
        assertEquals(1234.56, roundToTwoDigits(1234.5678))
    }

    @Test
    fun `roundToTwoDigits is locale-independent for French locale`() {
        Locale.setDefault(Locale.FRANCE)
        assertEquals(45500.99, roundToTwoDigits(45500.999))
    }
}