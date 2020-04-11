package temp

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

fun main() {
    val str: Array<Any> = arrayOf(1, "4", 2, "3")
    val int: Array<Any> = arrayOf(1, "4", 2, "3")
    val date: Array<Any> = arrayOf(
        LocalDate.parse("2019-03-31"),
        LocalDate.parse("1983-10-05"),
        LocalDate.parse("2019-02-20"))
    val blockB: KClass<*> = String::class



    val blockF = str.filterIsInstance<String>()

    for (i in blockF){
        println(i)
    }

    val blockDate = date.filterIsInstance<LocalDate>().max()

    println(getData(str, String::class))
    println(getData(int, Int::class))
    println(getData(date, LocalDate::class))


    val any = getData(str, Double::class)
}

fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
    if (blockB == String::class){
        return blockA.filterIsInstance<String>().joinToString("")
    }
    if (blockB == Int::class){
        return blockA.filterIsInstance<Int>().sum()
    }
    if (blockB == LocalDate::class){
        val list = blockA.filterIsInstance<LocalDate>().sortedDescending()
        var formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        return list[0].format(formatter)
    }
    throw NotImplementedError("Not implemented")
}

