package u02.Lab02Tests

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u02.esLab02.Lab02_4.Shape

class TestLab02_4 {
    @Test
    def calculatePerimeterTest(): Unit = {
        val length = 10
        val width = 20
        val rectangle = Shape.Rectangle(length, width)
        assertEquals(length * 2 + width * 2, Shape.perimeter(rectangle))

        val radius = 5
        val circle = Shape.Circle(radius)
        assertEquals(2 * math.Pi * radius, Shape.perimeter(circle))

        val side = 50
        val square = Shape.Square(side)
        assertEquals(side * 4, Shape.perimeter(square))
    }

    @Test
    def calculateAreaTest(): Unit = {
        val length = 10
        val width = 20
        val rectangle = Shape.Rectangle(length, width)
        assertEquals(length * width, Shape.area(rectangle))

        val radius = 5.34
        val circle = Shape.Circle(radius)
        assertEquals(math.Pi * radius * radius, Shape.area(circle))

        val side = 50
        val square = Shape.Square(side)
        assertEquals(side * side, Shape.area(square))
    }
}
