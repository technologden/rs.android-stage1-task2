package subtask4

import temp.editWord
import temp.isPangram

class Pangram {

    // TODO: Complete the following function
    fun getResult(inputString: String): String {
        var words = listOf<String>()
        words = inputString
            .trim()
            .split(" ")
            .filter { it != "" }
            .filter { it != "\n" }
            .map { editWord(it, isPangram(inputString)) }
            .sortedBy { it[0] }

        return words.joinToString(" ")
    }

    private fun isPangram(string: String):Boolean{
        for (char in ('A'..'Z')){
            if (!string.contains(char, true))
                return false
        }
        return true
    }

    private fun editWord(word:String, boolean: Boolean): String{
        val charList = mutableListOf<Char>()
        var count = 0
        if (boolean){
            for (char in word){
                when(char){
                    'a', 'e', 'i', 'o', 'u', 'y',
                    'A', 'E', 'I', 'O', 'U', 'Y' -> {
                        charList.add(char.toUpperCase())
                        count++
                    }
                    else -> charList.add(char)
                }
            }
        }else{
            for (char in word){
                when(char){
                    'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
                    'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z',
                    'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
                    'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Z' ->
                    {
                        charList.add(char.toUpperCase())
                        count++
                    }
                    else -> charList.add(char)
                }
            }
        }
        return "$count${charList.joinToString("")}"
    }
}
