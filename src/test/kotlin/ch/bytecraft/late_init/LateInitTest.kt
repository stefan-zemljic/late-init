package ch.bytecraft.late_init

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExampleTest {
    class Example {
        var name: String by LateInit()
    }

    @Test
    fun `accessing name should throw UninitializedPropertyAccessException if not initialized`() {
        val example = Example()
        assertThrows<UninitializedPropertyAccessException> {
            example.name
        }
    }

    @Test
    fun `setting name should initialize the property`() {
        val example = Example()
        example.name = "Hello"
        assertEquals("Hello", example.name)
    }

    @Test
    fun `setting name more than once should throw IllegalStateException`() {
        val example = Example()
        example.name = "Hello"
        assertThrows<IllegalStateException> {
            example.name = "World"
        }
    }
}