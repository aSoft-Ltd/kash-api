@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package symphony.changes

import kotlinx.serialization.Serializable
import kotlinx.JsExport

@Serializable
data class NumberChangeBox(
    override val title: String,
    override val previous: Double,
    override val current: Double,
    override val details: String,
    override val feeling: ChangeFeeling,
    override val priority: Int = -1
) : ChangeBox<Double>() {
    override val change by lazy { changeRemarkOf(previous, current, feeling) }
}