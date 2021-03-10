package u02.Lab02Tests

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u02.esLab02.Lab02_3.{fib, tailFib}

class TestLab02_3 {
    @Test
    def testFib(): Unit = {
        assertEquals(1, fib(2))
        assertEquals(0, fib(0))
        assertEquals(55, fib(10))
        assertEquals(196418, fib(27))
    }

    @Test
    def testTailFib(): Unit = {
        assertEquals(1, tailFib(2))
        assertEquals(0, tailFib(0))
        assertEquals(55, tailFib(10))
        assertEquals(196418, tailFib(27))
    }
}
