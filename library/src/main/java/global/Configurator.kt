package global

import android.os.Handler
import until.storage.MemoryStore
import java.lang.RuntimeException

class Configurator private constructor() {
    private object Holder {
        val HOLDER = Configurator()
    }

    companion object {
        private val memoryStore = MemoryStore.instance
        private val mHandler = Handler()
        val INSTANCE: Configurator
            get() = Holder.HOLDER
    }

    fun init() {
        memoryStore.addData(GlobalKeys.IS_CONFIG_READY, false)
        memoryStore.addData(GlobalKeys.HANDLER, mHandler)
    }

    private fun checkConfigure() {
        val isReady = memoryStore.getData<Boolean>(GlobalKeys.IS_CONFIG_READY)
        if (!isReady) {
            throw RuntimeException("配置未完成")
        }
    }

    fun configure() {
        memoryStore.addData(GlobalKeys.IS_CONFIG_READY, true)
    }

    fun withApiHost(host: String): Configurator {
        memoryStore.addData(GlobalKeys.API_HOST, host)
        return this
    }

    fun <T> getConfiguration(key: String): T {
        checkConfigure()
        return memoryStore.getData(key)
    }

    fun <T> getConfiguration(key: Enum<*>): T {
        return getConfiguration(key.name)
    }
}