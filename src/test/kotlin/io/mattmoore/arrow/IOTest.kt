package io.mattmoore.arrow

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class IOTest {
  @Test
  fun `returns Failure type for failed IO`() {
    val result = io({ java.io.File("doesnt_exist.txt").readText() })
    assertTrue(result is Failure)
  }

  @Test
  fun `returns Success type for failed IO`() {
    val result = io({ java.io.File("name.txt").readText() })
    assertTrue(result is Success<*>)
  }
}
