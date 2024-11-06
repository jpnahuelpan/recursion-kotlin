/**
 * Author: J.P. Nahuelpán
 *
 * Retuns the fibonacci value of the given [number].
 * Definition:
 *    - f(0) = 0
 *    - f(1) = 1
 *    - f(n) = f(n - 1) + f(n - 2), for n > 1
 * Example: f(3) = f(2) + f(1)
 *               = (f(1) + f(0)) + 1
 *               = 1 + 1
 *               = 2 
 */

class Fibonacci {
    fun linear(n: Int): Int =
        if (evalBC(n)) n else if (n == 2) 1 else (1.618 * linear(n - 1) + 0.5).toInt()

    fun multiple(n: Int): Int =
        if (evalBC(n)) n else multiple(n - 1) + multiple(n - 2)

    tailrec fun tail(n: Int, acc: Int = 0, aux: Int = 1): Int =
        if (n == 0) acc else tail(n - 1, aux, acc + aux)

    fun mutual(n: Int): Int =
        if (n == 0) n else B(n) + A(n)

    fun nested(n: Int, s: Int = 0): Int =
        if (n == 0) 0 else if (evalNestedBC(n)) 1 + s else nested(n - 1, s + nested(n - 2, 0))

    private fun evalBC(n: Int): Boolean = (n == 0 || n == 1) 
    
    private fun evalNestedBC(n: Int): Boolean = (n == 1 || n == 2)
    
    private fun A(n: Int): Int {
        fun B(n: Int): Int =
            if (n == 1) n else A(n -1)
        return if (n == 1) 0 else A(n - 1) + B(n - 1)
    }

    private fun B(n: Int): Int {
        fun A(n: Int): Int =
            if (n == 1) 0 else A(n - 1) + B(n - 1)
        return if (n == 1) 1 else A(n - 1)
    }
}

class Testing {
    fun testFibonacci(f: (Int) -> Int, msg: String) {
        assertEquals(0, f(0), "${msg} failed, expect ${0}, found ${f(0)}.")
        assertEquals(1, f(1), "${msg} failed, expect ${1}, found ${f(1)}.")
        assertEquals(1, f(2), "${msg} failed, expect ${1}, found ${f(2)}.")
        assertEquals(2, f(3), "${msg} failed, expect ${2}, found ${f(3)}.")
        assertEquals(13, f(7), "${msg} failed, expect ${13}, found ${f(7)}.")
        assertEquals(55, f(10), "${msg} failed, expect ${55}, found ${f(10)}.")
        println("Test for ${msg} it's OK!")
    }

    private fun assertEquals(expected: Int, actual: Int, msg: String) {
        if (expected != actual) {
            println(msg)
            throw Exception("Fail the test.")
        }
    }
}


fun main() {
    val testing = Testing()
    val fibonacci = Fibonacci()
    testing.testFibonacci(fibonacci::linear, "Linear recursion.")
    testing.testFibonacci(fibonacci::multiple, "Multiple recursion.")
    testing.testFibonacci(fibonacci::tail, "Tail recursion.")
    testing.testFibonacci(fibonacci::mutual, "Mutual recursion.")
    testing.testFibonacci(fibonacci::nested, "Nested recursion.")
}
