package com.zebrains.libraries.androidutils

import com.zebrains.libraries.androidutils.datetime.parseDT
import org.junit.Test

import org.junit.Assert.*
import org.threeten.bp.LocalDateTime

/**
 * Покрыть Unit - тестами функции парсинга Даты / Времени из соответствующего модуля
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DateTimeUtilsUnitTest {

    companion object {
        const val PARSING_DATE = "10.01.2021 21:10"
        val EXPECTED_DATE = LocalDateTime.of(2021, 1, 10, 21, 10)
        val INCORRECT_DATE = LocalDateTime.of(2021, 10, 1, 21, 10)

    }

    @Test
    fun correct_parseDateTime() {
        assertEquals(EXPECTED_DATE, parseDT(PARSING_DATE))
    }

    @Test
    fun incorrect_parseDateTime() {
        assertNotEquals(INCORRECT_DATE, parseDT(PARSING_DATE))
    }


}
