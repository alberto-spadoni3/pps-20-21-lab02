package u02.esLab02

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
