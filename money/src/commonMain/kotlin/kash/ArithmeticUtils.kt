package kash

import kollections.Iterable
import kollections.forEach

fun Iterable<Money>.sum(): Money {
    var total: Money = Zero
    forEach { total += it }
    return total
}