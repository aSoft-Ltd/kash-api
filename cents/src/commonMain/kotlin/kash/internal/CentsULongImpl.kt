package kash.internal

import kash.Cents

@PublishedApi
internal data class CentsULongImpl(override val asLong: Long) : Cents {
//    override val asLong by lazy { asULong.toLong() }
    override val asDouble by lazy { asLong.toDouble() }

    override fun plus(other: Cents): Cents = CentsULongImpl(asLong + other.asLong)

    override fun minus(other: Cents): Cents = CentsULongImpl(asLong - other.asLong)

    override fun times(other: Double): Cents = CentsULongImpl((other * asLong.toDouble()).toLong())

    override fun times(other: Int): Cents = CentsULongImpl(other.toLong() * asLong)

    override fun div(other: Double): Cents = CentsULongImpl((asLong.toDouble() / other).toLong())

    override fun div(other: Int): Cents = CentsULongImpl((asLong / other.toLong()))

    override fun compareTo(other: Cents): Int = asLong.compareTo(other.asLong)

    override fun toString(): String = "$asLong cents"
}