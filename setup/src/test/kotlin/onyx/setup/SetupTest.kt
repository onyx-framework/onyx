package onyx.setup

import org.junit.Test

import org.junit.Assert.*

class SetupTest {

    @Test
    fun main() {
        Setup.main(arrayOf(""))
        assertTrue(Setup.status)

        val check = Setup.check()
        assertTrue(check)
    }
}