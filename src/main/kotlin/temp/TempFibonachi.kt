package temp

fun main() {
    val n = 15
    val result = IntArray(3)
    var count = 1
    while (fibonacci(count)* fibonacci(count - 1) < n){
        count++
    }
    println("${fibonacci(count - 1)}")
    println("${fibonacci(count)}")
    if (fibonacci(count-1)* fibonacci(count) == n)
        println(1)
    else
        println(0)

}

fun fibonacci(n: Int): Int {
    if (n == 0)
        return 0
    if (n == 1)
        return 1
    return fibonacci(n-2) + fibonacci(n-1)
}

