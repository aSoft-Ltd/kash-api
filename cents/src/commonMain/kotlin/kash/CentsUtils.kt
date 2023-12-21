@file:Suppress("NOTHING_TO_INLINE")

package kash

import kollections.Iterable
import kollections.sumOf

inline fun Iterable<Cents>.sum(): Cents = sumOf { it.asULong }.cents