@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE", "OPT_IN_USAGE")

package kash

import kash.serializer.CentsSerializer
import kotlinx.serialization.Serializable
import kotlinx.JsExport
import kotlin.js.JsName

@Serializable(with = CentsSerializer::class)
interface Cents : Numeral, Comparable<Cents> {
    operator fun plus(other: Cents): Cents
    operator fun minus(other: Cents): Cents
    operator fun times(other: Double): Cents

    @JsName("_ignore_timesInt")
    operator fun times(other: Int): Cents
    operator fun div(other: Double): Cents

    @JsName("_ignore_divInt")
    operator fun div(other: Int): Cents
}