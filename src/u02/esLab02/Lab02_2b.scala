package u02.esLab02

object Lab02_2b {
  // val with currying
  val p1: Double => Double => Double => Boolean = x => y => z => x <= y && y <= z

  // val without currying
  val p2: (Double, Double, Double) => Boolean = (x, y, z) => x <= y && y <= z

  // def with currying
  def p3(x: Double)(y: Double)(z: Double): Boolean = x <= y && y <= z

  // def without currying
  def p4(x: Double, y: Double, z: Double): Boolean = x <= y && y <= z

  // functional compositions
  def compose(f: Int => Int, g: Int => Int): Int => Int = i => f(g(i))

  // A constrain should be that the input functions f and g,
  // must wor with values that are all of the same type
  def genericCompose[A](f: A => A, g: A => A): A => A = i => f(g(i))
}
