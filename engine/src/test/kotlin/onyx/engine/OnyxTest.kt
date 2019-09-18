package onyx.engine

import junit.framework.Assert.assertTrue
import org.junit.Test

class OnyxTest {
    @Test
    fun main() {
        Onyx.main(arrayOf(""))
        val engine = Onyx.engine
        assertTrue(Onyx.engine == engine)
    }
}