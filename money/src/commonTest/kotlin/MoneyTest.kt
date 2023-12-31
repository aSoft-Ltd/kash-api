import kommander.expect
import kash.*
import kash.serializers.MoneySerializer
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class MoneyTest {
    @Test
    fun should_equal() {
        val m = 45.TZS
        println(m)
        println(Json.encodeToString(MoneySerializer, m))
    }

    @Test
    fun should_deserialize_correctly() {
        val json = """{"cents":50000,"currency":"TZS"}"""
        val money = Json.decodeFromString(MoneySerializer, json)
        expect(money).toBe(500.TZS)
        expect("TZS 500").toBe(money.toFormattedString())
    }

    @Test
    fun should_print_usd_correctly() {
        assertEquals("US$ 3", 3.00.USD.toFormattedString())
        assertEquals("US$ 3.15", 3.15.USD.toFormattedString(decimals = 2))
        assertEquals("USh 4.49", 4.49.UGX.toFormattedString(decimals = 2))
    }
}