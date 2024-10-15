package ch.bytecraft.late_init

class LateInit<T> {
    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: Any?): T {
        return value ?: throw UninitializedPropertyAccessException("Property not initialized")
    }

    operator fun setValue(thisRef: Any?, property: Any?, value: T) {
        if (this.value != null) throw IllegalStateException("Property already initialized")
        this.value = value
    }
}