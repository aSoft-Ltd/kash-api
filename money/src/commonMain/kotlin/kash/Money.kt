@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kash

import kash.serializers.MoneySerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.JsExport
import kotlin.js.JsName

@Deprecated("In favour of Cents or MoneyPresenter")
@Serializable(with = MoneySerializer::class)
interface Money : Pretty, Comparable<Money> {
    //cents
    /** In the lowest denomination */
    @SerialName("cents")
    val centsAsLong: ULong

    val centsAsInt: Int

    val centsAsDouble: Double

    // amounts
    val amountAsLong: Long

    val amountAsInt: Int

    val amountAsDouble: Double

    val currency: Currency

    // mappers
    fun with(currency: Currency): Money

    fun toMonetary(): Monetary

    // arithmetics
    operator fun plus(other: Money): Money

    operator fun minus(other: Money): Money

    operator fun times(quantity: Double): Money

    @JsName("_ignore_times_number")
    operator fun times(quantity: Number): Money

    operator fun div(quantity: Double): Money

    @JsName("_ignore_div")
    operator fun div(quantity: Number): Money

    @JsName("ratio")
    operator fun div(other: Money): MoneyRatio

    // comparators
    override fun compareTo(other: Money): Int
}