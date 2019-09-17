package onyx.engine

import mu.KLogging

/**
 * The Onyx Framework is an open source plugin based OSRS Private server
 * created by Vanic as hobby. Credits to all the resources that helped me with this project.
 * Polar, Tomm, and especially inspired by the RSMod project.
 *
 * @author Vanic
 */

object Onyx : KLogging() {

    lateinit var engine: Engine

    @JvmStatic
    fun main(args: Array<String>) {
        logger.info { "Initializing..." }

        engine = Engine()
        engine.start()
    }

}