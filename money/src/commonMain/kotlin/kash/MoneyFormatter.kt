@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kash

import neat.NumberFormatter
import kotlinx.JsExport
import kotlin.js.JsName

class MoneyFormatter(formatter: NumberFormatter) : NumberFormatter by formatter {

    @JsName("from")
    constructor(options: MoneyFormatterRawOptions) : this(NumberFormatter(options.toFormatterOptions()))

    @Deprecated("Do not use this method")
    fun format(o: Money): String = format(o.amountAsDouble)
        .replace(Template.CURRENCY_NAME, o.currency.name)
        .replace(Template.CURRENCY_GLOBAL_SYMBOL, o.currency.globalSymbol)
        .replace(Template.CURRENCY_LOCAL_SYMBOL, o.currency.localSymbol)
        .replace("X ", "")
}