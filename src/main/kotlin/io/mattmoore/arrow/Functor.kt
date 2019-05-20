package io.mattmoore.arrow

open class Functor<out A>(val value: A)

fun <A, B> Functor<A>.map(f: (A) -> B): Functor<B> = Functor(f(this.value))
