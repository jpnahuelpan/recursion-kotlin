package org.example

import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest

class FibonacciTest {
    companion object {
        @JvmStatic fun fibonacciInputs() = listOf(
            Arguments.of(0, 0),
            Arguments.of(1, 1),
            Arguments.of(1, 2),
            Arguments.of(2, 3),
            Arguments.of(3, 4),
            Arguments.of(5, 5),
            Arguments.of(8, 6),
            Arguments.of(13, 7),
            Arguments.of(21, 8),
            Arguments.of(55, 10)
        )
    }

    @ParameterizedTest
    @MethodSource("fibonacciInputs")
    fun `test linear recursion of fibonacci`(expected: Int, n: Int) {
        assertEquals(expected, Fibonacci.linear(n))
    }

    @ParameterizedTest
    @MethodSource("fibonacciInputs")
    fun `test tail resursion of fibonacci`(expected: Int, n: Int) {
        assertEquals(expected, Fibonacci.tail(n))
    }

    @ParameterizedTest
    @MethodSource("fibonacciInputs")
    fun `test multiple recursion of fibonacci`(expected: Int, n: Int) {
        assertEquals(expected, Fibonacci.multiple(n))
    }

    @ParameterizedTest
    @MethodSource("fibonacciInputs")
    fun `test mutual recursion of fibonacci`(expected: Int, n: Int) {
        assertEquals(expected, Fibonacci.mutual(n))
    }

    @ParameterizedTest
    @MethodSource("fibonacciInputs")
    fun `test nested recursion of fibonacci`(expected: Int, n: Int) {
        assertEquals(expected, Fibonacci.nested(n))
    }
}
