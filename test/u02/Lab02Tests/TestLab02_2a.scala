package u02.Lab02Tests

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test
import u02.esLab02.Lab02_2a.{neg, negAsGenericMethod, negAsMethod, parity, parityVal}

class TestLab02_2a {
    @Test
    def parityTest() {
        assertEquals("Odd", parity(21))
        assertEquals("Even", parity(2446))

        // Testing the val version
        assertEquals("Even", parityVal(2))
        assertEquals("Odd", parityVal(111))
    }


    @Test
    def testNeg(): Unit = {
        val notEmpty = negAsMethod(_=="")
        assertTrue(notEmpty("hello"))
        val empty = negAsMethod(_!="")
        assertTrue(empty(""))

        // Testing the val version
        val notEmpty2 = neg(_=="")
        assertTrue(notEmpty("hello"))
        val empty2 = neg(_=="")
        assertTrue(empty(""))
    }
    @Test
    def testGenericNeg(): Unit = {
        val notEmpty = negAsGenericMethod[String](_=="")
        assertTrue(notEmpty("hello"))
        assertFalse(notEmpty(""))
        val empty = negAsGenericMethod[String](_!="")
        assertTrue(empty(""))
        assertFalse(empty("Scala"))

        val notZero = negAsGenericMethod[Int](_==0)
        assertTrue(notZero(100))
        assertFalse(notZero(0))
        val zero = negAsGenericMethod[Int](_!=0)
        assertTrue(zero(0))
        assertFalse(zero(23))
    }
}
