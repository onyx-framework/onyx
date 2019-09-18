package onyx.engine

import onyx.setup.Setup
import kotlin.system.exitProcess

class Engine {

    private var state: EngineState = EngineState.OFF

    private fun init() {
        state = EngineState.INIT

        this.runChecks()

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

    private fun runChecks() {
        var success = true

        Onyx.logger.info { "Running engine pre-start checks." }
        val checks = Setup.check()

        checks.forEach { (_, state) ->
            if (!state) {
                success = false
            }
        }

        println("Engine Check Results")
        /**
         * Print header
         */
        println(String.format("%s","---------------------------------------------------------------------------"))
        println(String.format("%30s %25s %10s", "Name", "|", "Result"))
        println(String.format("%s","---------------------------------------------------------------------------"))

        checks.forEach { (checkClass, state) ->
            println(String.format("%30s %25s %10s", checkClass.simpleName, "|", state))
        }

        if(success) {
            Onyx.logger.info { "All checks passed. Continuing engine startup." }
        } else {
            Onyx.logger.error { "Some check have failed. Please review the above information." }
            exitProcess(-1)
        }
    }

}