package u02.esLab02

object Lab02_5 {
    sealed trait Option[A]
    object Option {
        case class None[A]() extends Option[A]
        case class Some[A](a: A) extends Option[A]

        def isEmpty[A](opt: Option[A]): Boolean = opt match {
            case None() => true
            case _ => false
        }

        def getOrElse[A, B >: A](opt: Option[A], orElse: B): B = opt match {
            case Some(a) => a
            case _ => orElse
        }

        def flatMap[A, B](opt: Option[A])(f:A => Option[B]): Option[B] = opt match {
            case Some(a) => f(a)
            case _ => None()
        }

        // Estensions for completing task 5
        def filter[A](opt: Option[A])(f:A => Boolean): Option[A] = opt match {
            case Some(a) if f(a) => Some(a)
            case _ => None()
        }

        def map[A, B](opt: Option[A])(f:A => B): Option[B] = opt match {
            case Some(a) => Some(f(a))
            case _ => None()
        }
    }
}
