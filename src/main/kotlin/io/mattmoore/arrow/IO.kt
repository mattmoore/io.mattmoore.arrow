package io.mattmoore.arrow

sealed class IO

class Success<T>(val value: T): IO()

class Failure: IO()

fun <T>io(function: () -> T): IO {
  return try { Success(function()) }
  catch (e: Throwable) { Failure() }
}
