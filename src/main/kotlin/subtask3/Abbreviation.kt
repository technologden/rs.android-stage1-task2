package subtask3

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        var bMod = b
        var result = mutableListOf<Char>()

        for (char in a.toUpperCase()){
            for (i in bMod){
                if (char == i){
                    result.add(char)
                    bMod = bMod.substringAfter(char)
                }
            }
        }

        return  if (b == result.joinToString ( "" )) "YES" else "NO"
    }
}
