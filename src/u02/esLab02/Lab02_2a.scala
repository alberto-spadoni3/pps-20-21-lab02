package u02.esLab02

object Lab02_2a {
  // function parity
  val parityVal: Int => String = {
    case n if n % 2 == 0 => "Even"
    case _ => "Odd"
  }

  def parity(x: Int): String = x match {
    case x if x % 2 == 0 => "Even"
    case x if x % 2 != 0 => "Odd"
  }

  // neg
  val neg: (String => Boolean) => String => Boolean = f => { s =>
    f(s) match {
      case true => false
      case _ => true
    }
  }

  def negAsMethod(f: String => Boolean): String => Boolean = f(_) match {
    case true => false
    case _ => true
  }

  def negAsGenericMethod[A](f: A => Boolean): A => Boolean = f(_) match {
    case true => false
    case _ => true
  }
}
