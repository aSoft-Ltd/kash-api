@file:JvmName("Cash")
@file:Suppress("NON_EXPORTABLE_TYPE")

package kash

import kash.internal.MonetaryImpl
import kotlinx.JsExport
import kotlin.js.JsName
import kotlin.jvm.JvmName

@PublishedApi
internal const val MONETARY_LOWEST_DENOMINATION = 100

val Zero: Monetary = MonetaryImpl(0u, Currency.UXX)

@Deprecated("Do not use this class anymore")
inline fun Money(cents: ULong, currency: Currency): Money = MonetaryImpl(cents, currency)

@JsExport
@JsName("moneyOf")
@JvmName("of")
@Deprecated("Do not use this class anymore")
inline fun Money(amount: Double, currency: Currency): Money = MonetaryImpl(
    centsAsLong = (amount * currency.lowestDenomination).toULong(),
    currency = currency
)

@JsName("monetaryOf")
@JvmName("of")
@Deprecated("Do not use this class anymore")
inline fun Monetary(amount: Double): Monetary = if (amount == 0.0) Zero else MonetaryImpl(
    centsAsLong = (amount * MONETARY_LOWEST_DENOMINATION).toULong(),
    currency = Currency.UXX
)

@Deprecated("Do not use this class anymore")
inline fun Number.toMonetary(currency: Currency = Currency.UXX): Monetary = MonetaryImpl(
    centsAsLong = (this.toDouble() * currency.lowestDenomination).toULong(),
    currency = currency
)

@Deprecated("Do not use this class anymore")
@JvmName("of")
inline fun Money(amount: Int, currency: Currency): Money = MonetaryImpl(
    centsAsLong = (amount.toDouble() * currency.lowestDenomination).toULong(),
    currency = currency
)

@JvmName("of")
@Deprecated("Do not use this class anymore")
inline fun Monetary(amount: Int): Monetary = if (amount == 0) Zero else MonetaryImpl(
    centsAsLong = (amount.toDouble() * MONETARY_LOWEST_DENOMINATION).toULong(),
    currency = Currency.UXX
)

@JvmName("of")
@Deprecated("Do not use this class anymore")
inline fun Money(amount: Long, currency: Currency): Money = MonetaryImpl(
    centsAsLong = (amount.toDouble() * currency.lowestDenomination).toULong(),
    currency = currency
)

@JvmName("of")
@Deprecated("Do not use this class anymore")
inline fun Monetary(amount: Long): Monetary = if (amount == 0L) Zero else MonetaryImpl(
    centsAsLong = (amount.toDouble() * MONETARY_LOWEST_DENOMINATION).toULong(),
    currency = Currency.UXX
)