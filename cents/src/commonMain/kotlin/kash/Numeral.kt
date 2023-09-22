@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE", "OPT_IN_USAGE")

package kash

import kotlin.js.JsExport

interface Numeral {
    val asULong: ULong
    val asLong: Long
    val asDouble: Double
}