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
    def negAsGenericMethod[A](f: A => Boolean): A => Boolean = f(_) match {
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

    // A constrain should be that the input functions f and g,
    // must wor with values that are all of the same type
    def genericCompose[A](f: A => A, g: A => A): A => A = i => f(g(i))
}

object Lab02_3 {
    def fib(n: Int): Int = n match {
        case 0 => 0
        case 1 | 2 => 1
        case _ => fib(n - 1) + fib(n - 2)
    }

    // fibonacci with tail recursion
    def tailFib(input: Int): Int = {
        @annotation.tailrec
        def _fib(n: Int, a: Int, b: Int): Int = n match {
            case 0 => a
            case 1 => b
            case _ => _fib(n - 1, b, a + b)
        }
        _fib(input, 0, 1)
    }
}