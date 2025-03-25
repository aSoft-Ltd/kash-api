@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kash

import kotlinx.JsExport

data class DoubleWrapper(
    val asDouble: Double
) {
    val asLong: Long get() = asDouble.toLong()
}