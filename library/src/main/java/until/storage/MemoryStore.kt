package until.storage

class MemoryStore private constructor() {
    private object Holder {
        val HOLDER = MemoryStore()
    }

    companion object {
        val instance: MemoryStore
            get() = Holder.HOLDER
    }

    private val mData = HashMap<String, Any>()

    fun addData(key: String, value: Any): MemoryStore {
        mData[key] = value
        return this
    }

    fun addData(key: Enum<*>, value: Any): MemoryStore {
        addData(key.name, value)
        return this
    }

    fun <T> getData(key: String): T {
        return mData[key] as T
    }

    fun <T> getData(key: Enum<*>): T {
        return getData(key.name)
    }
}