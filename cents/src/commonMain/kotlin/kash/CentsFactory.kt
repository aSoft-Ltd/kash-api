@file:Suppress("NOTHING_TO_INLINE", "NON_EXPORTABLE_TYPE", "OPT_IN_USAGE")

package kash

import kash.internal.CentsDoubleImpl
import kash.internal.CentsULongImpl
import kotlinx.JsExport
import kotlin.js.JsName

inline val Number.cents: Cents get() = CentsDoubleImpl(toDouble())

inline val Int.cents: Cents get() = if (this == 0) ZeroCents else CentsDoubleImpl(toDouble())

inline val Long.cents: Cents get() = if (this == 0L) ZeroCents else CentsDoubleImpl(toDouble())

inline val Double.cents: Cents get() = if (this == 0.0) ZeroCents else CentsDoubleImpl(toDouble())

inline val Double.centsBy100: Cents get() = if (this == 0.0) ZeroCents else CentsDoubleImpl((this * 100.0))


//inline val ULong.cents: Cents get() = if (this == 0uL) ZeroCents else CentsULongImpl(this)

@JsExport
@JsName("cents")
inline fun Cents(value: Double): Cents = value.cents