@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kash

import kash.serializers.MonetarySerializer
import kotlinx.serialization.Serializable
import kotlinx.JsExport
import kotlin.js.JsName

@Deprecated("In favour of Cents or MoneyPresenter")
@Serializable(with = MonetarySerializer::class)
interface Monetary : Money {

    @JsName("_ignore_plusNumber")
    operator fun plus(other: Number): Money

    @JsName("plusNumber")
    operator fun plus(other: Double): Money

    @JsName("_ignore_minusNumber")
    operator fun minus(other: Number): Money

    @JsName("timesNumber")
    operator fun minus(other: Double): Money
}