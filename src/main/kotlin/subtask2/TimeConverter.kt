package subtask2

import java.lang.NumberFormatException
import java.time.DateTimeException
import java.time.LocalTime

class TimeConverter {

    // TODO: Complete the following function
    fun toTextFormat(hour: String, minute: String): String {
        try {
            val time = LocalTime.of(hour.toInt(), minute.toInt())
            return when(time.minute){
                0 -> "${numToText(time.hour)} o' clock"
                1 -> "${numToText(time.minute)} minute past ${numToText(time.hour)}"
                in (2..29) -> {
                    if (time.minute == 15)
                        "quarter past ${numToText(time.hour)}"
                    else "${numToText(time.minute)} minutes past ${numToText(time.hour)}"
                }
                30 -> "half past ${numToText(time.hour)}"
                in (31..58) -> {
                    if (time.minute == 45)
                        "quarter to ${numToText(time.hour+1)}"
                    else "${numToText(60 - time.minute)} minutes to ${numToText(time.hour + 1)}"
                }
                59 -> "${numToText(60 - time.minute)} minute to ${numToText(time.hour + 1)}"
                else -> ""
            }
        } catch (e: DateTimeException){
            return ""
        } catch (e: NumberFormatException){
            return ""
        }
    }
}

fun numToText(number: Int): String{
    val array = arrayOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
        "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven",
        "twenty eight", "twenty nine")
    return array[number-1]
}
