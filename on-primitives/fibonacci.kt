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

fun baseCase(n: Int): Boolean = (n == 0 || n == 1)

fun fibonacci(n: Int): Int {
    return if (baseCase(n)) n else fibonacci(n - 2) + fibonacci(n - 1)
}

tailrec fun tlFibonacci(n: Int, acc: Int = 0, aux: Int = 1): Int {
    return if (n == 0) acc else tlFibonacci(n - 1, aux, acc + aux)
}


fun main() {
    println("f(0) = 0, result: simple ${fibonacci(0)}")
    println("f(1) = 1, result: simple ${fibonacci(1)}") 
    println("f(7) = 13, result simple ${fibonacci(7)}")
    println("f(10) = 55, result simple ${fibonacci(10)}")

    // with tailrec
    println("f(0) = 0, result: tailrec ${tlFibonacci(0)}")
    println("f(1) = 1, result: tailrec ${tlFibonacci(1)}") 
    println("f(7) = 13, result tailrec ${tlFibonacci(7)}")
    println("f(10) = 55, result tailrec ${tlFibonacci(10)}")   
}
