package onyx.setup

import mu.KLogging
import java.io.File

object Setup : KLogging() {

    var status = false

    private val dirs = arrayOf(
        "data/",
        "data/saves/",
        "data/cache/",
        "data/xteas/",
        "data/rsa/",
        "data/logs/",
        "data/plugins/"
    )

    fun check(): Boolean {
        logger.info { "Checking if server is ready to start." }

        /**
         * Check if dirs exist.
         */
        dirs.forEach { dir ->
            val file = File(dir)
            if(!file.exists()) return false
        }

        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
        status = this.setup()
    }

    private fun setup(): Boolean {
        if(this.check()) {
            println("Server does not need to be setup again.")
            return false
        }

        println("Setting up server...")

        /**
         * Create directories.
         */
        dirs.forEach { dir ->
            val file = File(dir)
            if(!file.exists()) {
                file.mkdirs()
                println("Create directory $dir as it did not exist.")
            }
        }

        println("Setup complete. You may now start the server.")
        return true
    }
}