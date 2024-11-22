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
package org.example

class Fibonacci {
    companion object {
        @JvmStatic fun linear(n: Int): Int =
            if (evalBC(n)) n else if (n == 2) 1 else (1.618 * linear(n - 1) + 0.5).toInt()

        @JvmStatic tailrec fun tail(n: Int, acc: Int = 0, aux: Int = 1): Int =
            if (n == 0) acc else tail(n - 1, aux, acc + aux)

        @JvmStatic fun multiple(n: Int): Int =
            if (evalBC(n)) n else multiple(n - 1) + multiple(n - 2)

        @JvmStatic fun mutual(n: Int): Int =
            if (n == 0) n else B(n) + A(n)

        @JvmStatic fun nested(n: Int, s: Int = 0): Int =
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
}

