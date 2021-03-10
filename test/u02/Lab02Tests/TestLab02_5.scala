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
        val predicate: String=> Boolean = _==string
        assertEquals(Some(string), filter(Some(string))(predicate))
        assertNotEquals(Some(string), filter(Some(string + "!"))(predicate))
    }
}
