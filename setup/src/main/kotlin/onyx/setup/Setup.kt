package onyx.setup

import onyx.setup.steps.DirectoryCheck

object Setup {

    private val step: MutableList<SetupStep> = mutableListOf()

    init {
        step by DirectoryCheck()
    }

    private infix fun <T: SetupStep> MutableList<T>.by(obj: T) {
        step.add(obj)
    }

    fun check(): HashMap<Class<out SetupStep>, Boolean> {

        val checkMap = hashMapOf<Class<out SetupStep>, Boolean>()
        step.forEach { s -> checkMap[s::class.java] = false }

        step.forEach { s ->
            checkMap[s::class.java] = s.check()
            if(!checkMap[s::class.java]!! && s is Actionable) {
                s.action()
                checkMap[s::class.java] = true
            }
        }

        return checkMap
    }
}
