@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kash

import kotlinx.JsExport

data class MoneyPresenter(
    val cents: Cents,
    val currency: Currency,
    val formatter: MoneyFormatter
) {
    val amount: Numeral by lazy { cents / 100 }

    fun toFormattedString(): String = formatter.format(amount.asDouble)
        .replace(Template.CURRENCY_NAME, currency.name)
        .replace(Template.CURRENCY_GLOBAL_SYMBOL, currency.globalSymbol)
        .replace(Template.CURRENCY_LOCAL_SYMBOL, currency.localSymbol)
        .replace("X ", "")
}