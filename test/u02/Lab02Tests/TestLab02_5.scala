package u02.Lab02Tests

import org.junit.jupiter.api.Assertions.{assertEquals, assertNotEquals}
import org.junit.jupiter.api.Test
import u02.esLab02.Lab02_5.Option._

class TestLab02_5 {
    @Test
    def filterTest(): Unit = {
        val value = 50
        val opt = Some(value)
        assertEquals(opt, filter(opt)(_>=40))
        assertEquals(None(), filter(opt)(_>=value+1))

        val string = "Scala"
        val equals: String => Boolean = _==string
        assertEquals(Some(string), filter(Some(string))(equals))
        assertNotEquals(Some(string), filter(Some(string + "!"))(equals))
    }

    @Test
    def mapTest(): Unit = {
        assertEquals(Some(true), map(Some(10))(_>5))
        assertEquals(Some(false), map(Some(100))(_==10))
        assertEquals(None(), map(None[Int]())(_<10))
    }
}
