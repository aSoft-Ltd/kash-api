@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kash

import kotlinx.JsExport

data class MoneyPresenter(
    val cents: Cents,
    val currency: Currency,
    val formatter: MoneyFormatter
) {
    val amount: DoubleWrapper by lazy { DoubleWrapper(cents.asDouble / 100.0) }

    fun toFormattedString(): String = formatter.format(cents.asDouble / 100.0)
        .replace(Template.CURRENCY_NAME, currency.name)
        .replace(Template.CURRENCY_GLOBAL_SYMBOL, currency.globalSymbol)
        .replace(Template.CURRENCY_LOCAL_SYMBOL, currency.localSymbol)
        .replace("X ", "")
}