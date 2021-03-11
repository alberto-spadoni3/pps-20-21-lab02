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

    @Test
    def map2Test(): Unit = {
        val opt1 = Some(23)
        val opt2 = Some(7)
        val composeNumbers: (Int, Int) => Int = _-_
        assertEquals(Some(16), map2(opt1, opt2, composeNumbers))

        val opt3 = Some("Hello ")
        val opt4 = Some("World")
        val composeStrings: (String, String) => String = _+_
        assertEquals(Some("Hello World"), map2(opt3, opt4, composeStrings))

        val opt5 = Some(3.14)
        val opt6 = Some(25.5)
        val composeDoubles: (Double, Double) => Double = _*_
        assertEquals(Some(3.14*25.5), map2(opt5, opt6, composeDoubles))

        val opt7 = None[Int]()
        assertEquals(None(), map2(opt1, opt7, composeNumbers))
    }
}
