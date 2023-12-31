@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package symphony.changes

import kotlinx.serialization.Serializable
import kotlinx.JsExport

@Serializable
data class GenericChangeBox<out T>(
    override val title: String,
    override val previous: T,
    override val current: T,
    override val details: String,
    override val feeling: ChangeFeeling,
    override val priority: Int = -1,
) : ChangeBox<T>() {
    override val change: ChangeRemark<T> get() = ChangeRemark.Indeterminate
}