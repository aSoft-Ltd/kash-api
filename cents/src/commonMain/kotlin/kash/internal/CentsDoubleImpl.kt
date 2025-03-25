package kash.internal

import kash.Cents

@PublishedApi
internal data class CentsDoubleImpl(val doubleValue: Double) : Cents {

    override val asLong: Long by lazy { doubleValue.toLong() }

    override val asDouble by lazy { doubleValue }

    override fun plus(other: Cents): Cents = CentsDoubleImpl(asDouble + other.asDouble)

    override fun minus(other: Cents): Cents = CentsDoubleImpl(asDouble - other.asDouble)

    override fun times(other: Double): Cents = CentsDoubleImpl((other * asDouble))

    override fun times(other: Int): Cents = CentsDoubleImpl(other.toLong() * asDouble)

    override fun div(other: Double): Cents = CentsDoubleImpl((asDouble / other))

    override fun div(other: Int): Cents = CentsDoubleImpl((asDouble / other))

    override fun compareTo(other: Cents): Int = asDouble.compareTo(other.asDouble)

    override fun toString(): String = "$asDouble cents"
}