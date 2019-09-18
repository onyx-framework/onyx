package onyx.setup.steps

import mu.KLogging
import onyx.setup.Actionable
import onyx.setup.SetupStep
import java.io.File

class DirectoryCheck : SetupStep(), Actionable {

    private val dirs = arrayOf(
        "data/",
        "data/saves/",
        "data/plugins/",
        "data/defs/",
        "data/cache/",
        "data/xteas/",
        "data/rsa/",
        "data/logs/"
    )

    override fun check(): Boolean {
        dirs.forEach { dir ->
            val file = File(dir)
            if(!file.exists()) return false
        }

        return true
    }

    override fun action(): Boolean {
        dirs.forEach { dir ->
            val file = File(dir)
            if(!file.exists()) {
                file.mkdirs()
                logger.info("Created directory {} as it did not exist.", dir)
            }
        }

        return true
    }

    companion object : KLogging()
}