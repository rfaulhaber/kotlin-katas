import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import rack.Rack
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RackTest : Spek({
    given("a rack of letters") {
        val rack = Rack("ladilmy")

        it("should contain a word made up of given letters") {
            assertTrue(rack.contains("daily"))
        }

        it("should not contain a word made up of letters not given") {
            assertFalse(rack.contains("program"))
        }
    }
})