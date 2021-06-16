package com.zebrains.libraries.androidutils

import com.zebrains.libraries.androidutils.datetime.*
import com.zebrains.libraries.androidutils.datetime.formattedTimestamp
import org.junit.Test

import org.junit.Assert.*
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime

/**
 * Покрыть Unit - тестами функции парсинга Даты / Времени из соответствующего модуля
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DateTimeUtilsUnitTest {

    companion object {
        const val PARSING_DATE = "10.01.2021 21:10"
        const val PARSING_TIME_DAY = "вс, 10 января 2021 г. 21:10"
        const val TIMESTAMP = "2021-01-10_2110"
        const val IN_DATE = "10.1.2021"
        const val DATE_WITHOUT_TIME = "вс, 10 января 2021 г."
        const val DAY = "10 января 2021, воскресенье"
        const val OUT_DATE = "10.01.2021"
        const val OUT_TIME = "21:10"

        const val FIRST_TIME = "12:20"
        const val SECOND_TIME = "14:40"

        val EXPECTED_DATE = LocalDateTime.of(2021, 1, 10, 21, 10)
        val INCORRECT_DATE = LocalDateTime.of(2021, 10, 1, 21, 21)

        val EXPECTED_DATE_WITHOUT_TIME = LocalDate.of(2021, 1, 10)
        val INCORRECT_DATE_WITHOUT_TIME = LocalDate.of(2021, 10, 1)

    }

    @Test
    fun correct_parseDT() {
        assertEquals(EXPECTED_DATE, parseDT(PARSING_DATE))
    }

    @Test
    fun incorrect_parseDT() {
        assertNotEquals(INCORRECT_DATE, parseDT(PARSING_DATE))
    }

    @Test
    fun correct_parseDateTime() {
        assertEquals(EXPECTED_DATE, parseDateTime(PARSING_TIME_DAY))
    }

    @Test
    fun incorrect_parseDateTime() {
        assertNotEquals(INCORRECT_DATE, parseDateTime(PARSING_TIME_DAY))
    }

    @Test
    fun correct_formattedDateTime() {
        assertEquals(formattedDateTime(EXPECTED_DATE), PARSING_DATE)
    }

    @Test
    fun incorrect_formattedDateTime() {
        assertNotEquals(formattedDateTime(INCORRECT_DATE), PARSING_DATE)
    }

    @Test
    fun correct_formattedTimestamp() {
        assertEquals(formattedTimestamp(EXPECTED_DATE), TIMESTAMP)
    }

    @Test
    fun incorrect_formattedTimestamp() {
        assertNotEquals(formattedTimestamp(INCORRECT_DATE), TIMESTAMP)
    }

    @Test
    fun correct_parseDate() {
        assertEquals(parseDate(IN_DATE), EXPECTED_DATE_WITHOUT_TIME)
    }

    @Test
    fun incorrect_parseDate() {
        assertNotEquals(parseDate(IN_DATE), INCORRECT_DATE_WITHOUT_TIME)
    }

    @Test
    fun correct_formattedDate() {
        assertEquals(formattedDate(EXPECTED_DATE), DATE_WITHOUT_TIME)
    }

    @Test
    fun incorrect_formattedDate() {
        assertNotEquals(formattedDate(INCORRECT_DATE), DATE_WITHOUT_TIME)
    }

    @Test
    fun correct_formattedToday() {
        assertEquals(formattedToday(EXPECTED_DATE_WITHOUT_TIME), DAY)
    }

    @Test
    fun incorrect_formattedToday() {
        assertNotEquals(formattedToday(INCORRECT_DATE_WITHOUT_TIME), DAY)
    }

    @Test
    fun correct_formattedOutDate() {
        assertEquals(formattedOutDate(EXPECTED_DATE), OUT_DATE)
    }

    @Test
    fun incorrect_formattedOutDate() {
        assertNotEquals(formattedOutDate(INCORRECT_DATE), OUT_DATE)
    }

    @Test
    fun correct_formattedOutTime() {
        assertEquals(formattedOutTime(EXPECTED_DATE), OUT_TIME)
    }

    @Test
    fun incorrect_formattedOutTime() {
        assertNotEquals(formattedOutTime(INCORRECT_DATE), OUT_TIME)
    }

    @Test
    fun currentYearTest() {
        assertEquals(getCurrentYear(), 2021)
    }

    @Test
    fun currentMonthTest() {
        assertEquals(getCurrentMonth(), 6)
    }

    @Test
    fun currentDayTest() {
        assertEquals(getCurrentDay(), 3)
    }

    @Test
    fun daysOfCurrentYearTest() {
        assertEquals(daysOfCurrentYear(), 365)
    }

    @Test
    fun daysOfCurrentMonthTest() {
        assertEquals(daysOfCurrentMonth(), 30)
    }

    @Test
    fun getFirstDayOfWeekTest() {
        assertEquals(getFirstDayOfWeek(), LocalDate.of(2021, 5, 31))
    }

    @Test
    fun getLastDayOfWeekTest() {
        assertEquals(getLastDayOfWeek(), LocalDate.of(2021, 6, 6))
    }

    @Test
    fun nextDayTest() {
        assertEquals(
            nextDay(3),
            formattedToday(LocalDate.of(2021, 6, 6))
        )
    }

    @Test
    fun previousDayTest() {
        assertEquals(
            previousDay(3),
            formattedToday(LocalDate.of(2021, 5, 31))
        )
    }

    @Test
    fun correct_compareTimeTest() {
        assertEquals(compareTime(FIRST_TIME, SECOND_TIME), true)
    }

    @Test
    fun incorrect_compareTimeTest() {
        assertNotEquals(compareTime(SECOND_TIME, FIRST_TIME), true)
    }
}
