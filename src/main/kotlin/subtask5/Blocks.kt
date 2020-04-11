package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    // TODO: Complete the following function
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
}
