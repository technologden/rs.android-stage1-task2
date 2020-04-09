package subtask1

import java.time.DateTimeException
import java.time.DayOfWeek
import java.time.LocalDate

class DateFormatter {

    // TODO: Complete the following function
    fun toTextDay(day: String, month: String, year: String): String {
        var monthEd = if (month.length ==1) "0$month" else month

        try {
            val date = LocalDate.parse("$year-$monthEd-$day")

            val textMonth = when(monthEd){
                "01" -> "января"
                "02" -> "февраля"
                "03" -> "марта"
                "04" -> "апреля"
                "05" -> "мая"
                "06" -> "июня"
                "07" -> "июля"
                "08" -> "августа"
                "09" -> "сентября"
                "10" -> "октября"
                "11" -> "ноября"
                "12" -> "декабря"
                else -> ""
            }

            val textDayOfWeek = when(date.dayOfWeek){
                DayOfWeek.MONDAY -> "понедельник"
                DayOfWeek.TUESDAY -> "вторник"
                DayOfWeek.WEDNESDAY -> "среда"
                DayOfWeek.THURSDAY -> "четверг"
                DayOfWeek.FRIDAY -> "пятница"
                DayOfWeek.SATURDAY -> "суббота"
                DayOfWeek.SUNDAY -> "воскресенье"
            }

            return "$day $textMonth, $textDayOfWeek"
        } catch (e: DateTimeException){
            return "Такого дня не существует"
        }
    }
}
