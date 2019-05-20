package io.mattmoore.arrow

import kotlin.test.Test
import kotlin.test.assertEquals

class FunctorTest {
    @Test
    fun `map a function over a functor`() {
        fun inc(n: Int) = n + 1
        val result = Functor(1).map(::inc).map(::inc)
        assertEquals(result.value, 3)
    }
}
