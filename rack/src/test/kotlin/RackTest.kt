import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import rack.Rack
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RackTest : Spek({
    given("a rack of letters") {
        val rack = Rack("ladilmy")
        val rack2 = Rack("pizza??")

        it("should contain a word made up of given letters") {
            assertTrue(rack.contains("daily"))
            assertTrue(rack.contains("my"))
            assertTrue(rack.contains("laid"))
        }

        it("should not contain a word made up of letters not given") {
            assertFalse(rack.contains("program"))
            assertFalse(rack.contains("control"))
            assertFalse(rack.contains("gradle"))
        }

        it("should match wildcard tiles") {
            assertTrue(rack2.contains("pizzazz"))
            assertTrue(rack2.contains("pizza"))
            assertFalse(rack2.contains("marathon"))
        }
    }
})