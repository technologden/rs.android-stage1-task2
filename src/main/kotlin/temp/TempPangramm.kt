package temp

fun main() {
    val inputStr = "asdasdasdasda \n" +
            "                            sdasdadasd sadasdasdas \n" +
            "                            sadadad  "
    val resultStr = "4SaDaDaD 7SDaSDaDaSD 7SaDaSDaSDaS 8aSDaSDaSDaSDa"
    var words = listOf<String>()
    words = inputStr
        .trim()
        .split(" ")
        .filter { it != "" }
        .filter { it != "\n" }
        .map {editWord(it, isPangram(inputStr)) }
        .sortedBy { it[0] }

    println(words.joinToString(" "))
    println(resultStr)

    print(words.joinToString(" ")==resultStr)


}

fun isPangram1(string: String):Boolean{
    val sample = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    var result = mutableListOf<Char>()
    for (i in sample){
        for(j in string.toUpperCase()){
            if (i == j ){
                result.add(j)
                break
            }
        }
    }
    return result.joinToString("")==sample
}

fun isPangram2(string: String):Boolean{
    val sample = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    var result = mutableListOf<Char>()
    for (char in sample){
        if (string.contains(char, true))
            result.add(char)
    }
    return result.joinToString("")==sample
}
//best
fun isPangram(string: String):Boolean{
    for (char in ('A'..'Z')){
        if (!string.contains(char, true))
            return false
    }
    return true
}

fun editWord(word:String, boolean: Boolean): String{
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