package onyx.engine

import org.junit.Test
import kotlin.test.assertEquals

class EngineTest {
    val engine: Engine = Engine()
    val engineState = Engine::class.java.getDeclaredField("state")

    init {
        engineState.isAccessible = true
    }

    @Test
    fun startTest() {
        engine.start()
        val state = engineState.get(engine) as EngineState

        assertEquals(EngineState.RUNNING, state)
    }

    @Test
    fun terminateTest() {
        engine.terminate()

        val state = engineState.get(engine) as EngineState

        assertEquals(EngineState.OFF, state)
    }
}