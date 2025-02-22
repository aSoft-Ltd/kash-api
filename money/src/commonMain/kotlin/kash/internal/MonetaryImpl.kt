package kash.internal

import kash.Currency
import kash.Monetary
import kash.Money
import kash.MoneyFormatter
import kash.MoneyRatio
import kash.Zero
import kash.exceptions.CurrencyMatchException
import kash.toMonetary

@PublishedApi
internal data class MonetaryImpl(
    override val centsAsLong: Long,
    override val currency: Currency
) : AbstractPretty(), Monetary {

    override val centsAsInt = centsAsLong.toInt()

    override val centsAsDouble = centsAsLong.toDouble()

    override val amountAsLong = (centsAsLong.toLong() / currency.lowestDenomination)

    override val amountAsInt = (centsAsLong.toInt() / currency.lowestDenomination)

    override val amountAsDouble = (centsAsLong.toDouble() / currency.lowestDenomination)

    override fun with(currency: Currency) = MonetaryImpl(centsAsLong, currency)

    override fun toMonetary(): Monetary = this

    private fun currencyCheckFor(op: String, other: Money) {
        if (other.currency != currency) {
            throw CurrencyMatchException(currency, op, other.currency)
        }
    }

    override operator fun plus(other: Money) = when {
        centsAsLong == 0L && other.centsAsLong == 0L -> Zero
        centsAsLong == 0L && other.centsAsLong != 0L -> MonetaryImpl(other.centsAsLong, other.currency)
        centsAsLong != 0L && other.centsAsLong == 0L -> this
        else -> {
            currencyCheckFor("addition", other)
            MonetaryImpl(centsAsLong + other.centsAsLong, currency)
        }
    }

    override fun format(formatter: MoneyFormatter): String = formatter.format(this)

    override operator fun plus(other: Number) = plus(other.toDouble())

    override operator fun plus(other: Double) = this + other.toMonetary(currency)

    override operator fun minus(other: Money) = when {
        centsAsLong == 0L && other.centsAsLong == 0L -> Zero
        centsAsLong == 0L && other.centsAsLong != 0L -> MonetaryImpl(other.centsAsLong, other.currency)
        centsAsLong != 0L && other.centsAsLong == 0L -> this
        else -> {
            currencyCheckFor("subtraction", other)
            MonetaryImpl(centsAsLong - other.centsAsLong, currency)
        }
    }

    override fun minus(other: Double) = this - other.toMonetary(currency)

    override fun minus(other: Number) = minus(other.toDouble())

    override operator fun times(quantity: Double) = MonetaryImpl((centsAsDouble * quantity).toLong(), currency)

    override operator fun times(quantity: Number) = times(quantity.toDouble())

    override operator fun div(quantity: Double) = MonetaryImpl((centsAsDouble / quantity).toLong(), currency)

    override operator fun div(quantity: Number) = div(quantity.toDouble())

    override operator fun div(other: Money) = MoneyRatio(
        value = (centsAsDouble / other.centsAsDouble),
        numerator = currency,
        denominator = other.currency
    )

    override fun compareTo(other: Money): Int = when {
        centsAsLong == 0L && other.centsAsLong == 0L -> 0
        centsAsLong == 0L && other.centsAsLong != 0L -> -centsAsInt
        centsAsLong != 0L && other.centsAsLong == 0L -> centsAsInt
        else -> {
            currencyCheckFor("comparison", other)
            centsAsInt - other.centsAsInt
        }
    }

    override fun toString() = toFormattedString(abbreviate = false)
}