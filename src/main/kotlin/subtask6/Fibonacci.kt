package subtask6

class Fibonacci {

    // TODO: Complete the following function
    fun productFibonacciSequenceFor(n: Int): IntArray {
        val result = IntArray(3)
        var count = 1

        while (fibonacci(count) * fibonacci(count - 1) < n){
            count++
        }

        result[0] = fibonacci(count - 1)
        result[1] = fibonacci(count)
        if (fibonacci(count) * fibonacci(count - 1) == n)
            result[2] = 1
        else result[2] = 0

        return result
    }

    private fun fibonacci(n: Int): Int {
        if (n == 0)
            return 0
        if (n == 1)
            return 1
        return fibonacci(n-2) + fibonacci(n-1)
    }
}
