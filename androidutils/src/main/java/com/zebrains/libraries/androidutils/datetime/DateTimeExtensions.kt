package com.zebrains.libraries.androidutils.datetime

import java.util.*
import org.threeten.bp.*
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.temporal.TemporalAdjusters

const val DATE_TIME_FORMATTER = "dd.MM.yyyy HH:mm"
const val TIME_STAMP_FORMATTER = "yyyy-MM-dd_HHmm"
const val IN_DATE_FORMATTER = "d.M.yyyy"
const val DATE_TIME_DAY_FORMATTER = "EE, dd MMMM yyyy г. H:m"
const val DATE_FORMATTER = "EE, dd MMMM yyyy г."
const val TIME = "H:m"
const val DAY_FORMATTER = "dd MMMM yyyy, EEEE"
const val OUT_DATE = "dd.MM.yyyy"
const val OUT_TIME = "HH:mm"

fun parseDT(date: String, format: String = DATE_TIME_FORMATTER): LocalDateTime =
    LocalDateTime.parse(date, DateTimeFormatter.ofPattern(format).withLocale(Locale.getDefault()))

fun parseDateTime(date: String): LocalDateTime =
    LocalDateTime.parse(
        date,
        DateTimeFormatter.ofPattern(DATE_TIME_DAY_FORMATTER).withLocale(Locale.getDefault())
    )

fun formattedDateTime(date: LocalDateTime): String =
    date.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMATTER).withLocale(Locale.getDefault()))

fun formattedTimestamp(date: LocalDateTime): String =
    date.format(DateTimeFormatter.ofPattern(TIME_STAMP_FORMATTER))

fun parseDate(date: String): LocalDate =
    LocalDate.parse(
        date,
        DateTimeFormatter.ofPattern(IN_DATE_FORMATTER).withLocale(Locale.getDefault())
    )

fun formattedDate(date: LocalDateTime): String = date.format(
    DateTimeFormatter.ofPattern(
        DATE_FORMATTER
    )
)

fun formattedToday(date: LocalDate): String =
    date.format(DateTimeFormatter.ofPattern(DAY_FORMATTER).withLocale(Locale.getDefault()))

fun formattedOutDate(date: LocalDateTime): String =
    date.format(DateTimeFormatter.ofPattern(OUT_DATE).withLocale(Locale.getDefault()))

fun formattedOutTime(date: LocalDateTime): String =
    date.format(DateTimeFormatter.ofPattern(OUT_TIME).withLocale(Locale.getDefault()))

fun extractDate(dateTime: String): LocalDateTime = parseDT(dateTime)
fun extractTime(dateTime: String): LocalDateTime = parseDT(dateTime)
fun extractDateString(dateTime: String): String = formattedOutDate(parseDT(dateTime))
fun extractTimeString(dateTime: String): String = formattedOutTime(parseDT(dateTime))

fun daysOfCurrentMonth(): Int = LocalDate.now(ZoneId.systemDefault()).lengthOfMonth()
fun daysOfCurrentYear(): Int = LocalDate.now(ZoneId.systemDefault()).lengthOfYear()

fun getCurrentTime(): LocalTime = LocalTime.now(ZoneId.systemDefault())
fun getCurrentDate(): LocalDate = LocalDate.now(ZoneId.systemDefault())
fun getCurrentDateTime(): LocalDateTime = LocalDateTime.now(ZoneId.systemDefault())
fun getCurrentDateInMills(): Long = Instant.now().epochSecond
fun getCurrentYear(): Int = LocalDate.now(ZoneId.systemDefault()).year
fun getCurrentMonth(): Int = LocalDate.now(ZoneId.systemDefault()).monthValue
fun getCurrentDay(): Int = LocalDate.now(ZoneId.systemDefault()).dayOfMonth

fun getFirstDayOfWeek(): LocalDate =
    LocalDate.now(ZoneId.systemDefault()).with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))

fun getLastDayOfWeek(): LocalDate =
    LocalDate.now(ZoneId.systemDefault()).with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY))

fun nextDay(count: Int): String = formattedToday(getCurrentDate().plusDays(count.toLong()))
fun previousDay(count: Int): String = formattedToday(getCurrentDate().minusDays(count.toLong()))

fun compareTime(after: String?, before: String?): Boolean {
    val a = LocalTime.parse(after, DateTimeFormatter.ofPattern(TIME))
    val b = LocalTime.parse(before, DateTimeFormatter.ofPattern(TIME))
    return a.isBefore(getCurrentTime()) && b.isAfter(getCurrentTime())
}

fun LocalDateTime.toMillis(zone: ZoneId = ZoneId.systemDefault()) =
    atZone(zone)?.toInstant()?.toEpochMilli()