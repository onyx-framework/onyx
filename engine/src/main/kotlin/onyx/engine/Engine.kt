package onyx.engine

class Engine {

    private var state: EngineState = EngineState.OFF

    private fun init() {
        state = EngineState.INIT

        Onyx.logger.info { "Engine initialization complete." }
    }

    internal fun start() {
        this.init()

        Onyx.logger.info { "Starting Onyx engine." }

        state = EngineState.STARTUP

        Onyx.logger.info { "Onyx engine startup complete." }

        this.postStart()
    }

    private fun postStart() {
        state = EngineState.RUNNING

        Onyx.logger.info { "Server is up and running." }
    }

    internal fun terminate() {
        state = EngineState.SHUTDOWN
        Onyx.logger.info { "Server shutdown signal received. Terminating all services." }

        Onyx.logger.info { "Server has been fully terminated." }
        state = EngineState.OFF
    }

}