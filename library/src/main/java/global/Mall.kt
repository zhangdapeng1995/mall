package global

import android.content.Context
import until.storage.MemoryStore

object Mall {
    private val memoryStore = MemoryStore.instance
    private val configurator
        get() = Configurator.INSTANCE

    fun init(context: Context): Configurator {
        memoryStore.addData(GlobalKeys.CONTEXT, context.applicationContext)
        return configurator
    }

    fun <T> getConfiguration(key: String): T {
        return memoryStore.getData(key)
    }

    fun <T> getConfiguration(key: Enum<GlobalKeys>): T {
        return getConfiguration(key.name)
    }
}