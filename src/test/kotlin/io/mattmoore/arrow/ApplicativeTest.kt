package io.mattmoore.arrow

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ApplicativeTest {
    private fun inc(x: Int) = x + 1
    private fun add(x: Int) = { y: Int -> x + y }

    @Test
    fun `apply the function to the value`() {
        val result = Functor(1).apply(Functor(::inc))
        assertEquals(result.value, 2)
    }

    @Test
    fun `apply the value to the function`() {
        val result = Functor(::inc).apply(Functor(1))
        assertEquals(result.value, 2)
    }

    @Test
    fun `map a function to a value, then apply another value`() {
        val result = Functor(1).map(::add).apply(Functor(1))
        assertEquals(result.value, 2)
    }

    @Test
    fun `apply two values (parameters) to the function`() {
        fun add(x: Int) = { y: Int -> x + y }
        val result = Functor(::add).apply(Functor(1)).apply(Functor(1))
        assertEquals(result.value, 2)
    }
}
