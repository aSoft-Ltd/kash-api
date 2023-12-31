@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package symphony.changes

import kash.Money
import kotlinx.serialization.Serializable
import kotlinx.JsExport

@Serializable
data class MoneyChangeBox(
    override val title: String,
    override val previous: Money,
    override val current: Money,
    override val details: String,
    override val feeling: ChangeFeeling,
    override val priority: Int = -1,
) : ChangeBox<Money>() {
    override val change: ChangeRemark<Money> by lazy { changeRemarkOf(previous, current, feeling) }
}