package onyx.setup

import junit.framework.TestCase.assertTrue
import org.junit.Test

class SetupTest {

    private val stepField = Setup::class.java.getDeclaredField("step")

    init {
        stepField.isAccessible = true
    }

    @Suppress("UNCHECKED_CAST")
    @Test
    fun stepAddTest() {
        val steps: MutableList<SetupStep> = stepField.get(Setup) as MutableList<SetupStep>
        assertTrue(steps.size > 0)
    }

    @Test
    fun checkTest() {
        val checks = Setup.check()
        assertTrue(checks.size > 0)
    }

}