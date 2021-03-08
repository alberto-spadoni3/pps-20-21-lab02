package u02

object Lab02_2a {
  // function parity
  val parityVal : Int => String = {
    case n if n % 2 == 0 => "Even"
    case _ => "Odd"
  }
  def parity(x: Int) : String = x match {
    case x if x % 2 == 0 => "Even"
    case x if x % 2 != 0 => "Odd"
  }


  // neg
  val neg: (String => Boolean) => String => Boolean = f => {s => f(s) match {
      case true => false
      case _ => true
    }
  }
  def negAsMethod(f: String => Boolean): String => Boolean = f(_) match {
    case true => false
    case _ => true
  }
}

object Lab02_2b {
    // val with currying
    val p1: Double => Double => Double => Boolean = x => y => z => x <= y && y <= z

    // val without currying
    val p2: (Double, Double, Double) => Boolean = (x, y, z) => x <= y && y <= z

    // def with currying
    def p3(x:Double)(y:Double)(z:Double): Boolean = x <= y && y <= z

    // def without currying
    def p4(x:Double, y:Double, z:Double): Boolean = x <= y && y <= z

    // functional compositions
    def compose(f: Int => Int, g: Int => Int): Int => Int = i => f(g(i))
}
