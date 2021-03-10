package u02.esLab02

object Lab02_4 {
    sealed trait Shape
    object Shape {
        case class Rectangle(length: Double, width: Double) extends Shape
        case class Circle(radius: Double) extends Shape
        case class Square(side: Double) extends Shape

        def perimeter(shape: Shape): Double = shape match {
            case Rectangle(length, width) => length * 2 + width * 2
            case Circle(radius) => 2 * math.Pi * radius
            case Square(side) => side * 4
        }

        def area(shape: Shape): Double = shape match {
            case Rectangle(length, width) => length * width
            case Circle(radius) => math.Pi * radius * radius
            case Square(side) => side * side
        }
    }
}
