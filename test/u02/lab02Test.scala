package u02

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertNotEquals, assertTrue}
import org.junit.jupiter.api.Test
import u02.Lab02_2a.{neg, negAsGenericMethod, negAsMethod, parity, parityVal}
import u02.Lab02_2b.{compose, genericCompose, p1, p2, p3, p4}
import u02.Lab02_3.{fib, tailFib}

class lab02Test {
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


  @Test
  //  test p1 val which represent a curriedFunType using val
  def testP1(): Unit = {
      assertTrue(p1(12)(13)(14))
      assertFalse(p1(3)(4)(3))

      // Testing the partial application
      val partialX: Double => Double => Boolean = p1(8)
      assertFalse(partialX(9)(-10))
      val partialXY: Double => Boolean = partialX(9)
      assertTrue(partialXY(10))
      val completeXYZ: Boolean = partialXY(10)
      assertTrue(completeXYZ)
  }
  @Test
  //  test p2 val
  def testP2(): Unit = {
      assertTrue(p2(12,13,14))
      assertFalse(p2(3,4,3))
  }
  @Test
  def testP3(): Unit = {
      assertFalse(p3(-33)(-54)(2))
      assertTrue(p3(0)(2)(55))

      // Testing the partial application
      val partialX: Double => Double => Boolean = p3(8)
      assertFalse(partialX(9)(-10))
      val partialXY: Double => Boolean = partialX(9)
      assertTrue(partialXY(10))
      val completeXYZ: Boolean = partialXY(10)
      assertTrue(completeXYZ)
  }
  @Test
  def testP4(): Unit = {
      assertFalse(p4(1,2,0))
      assertTrue(p4(22,33,44))
  }


  @Test
  def testCompose(): Unit = {
      assertEquals(9, compose(_-1, _*2)(5))
      assertNotEquals(60, compose(_+10,_*2)(20))
  }
  @Test
  def testGenericCompose(): Unit = {
      val int = 10
      val partialInt = genericCompose[Int](_-1, _*2)
      assertEquals(int * 2 - 1, partialInt(int))
      assertNotEquals(int - 1 * 2, partialInt(int))

      val double = 13.5
      val partialDouble = genericCompose[Double](_*0.5, _-2.5)
      assertEquals((double-2.5)*0.5, partialDouble(double))

      val s1 = "Hello, "
      val s2 = "World"
      val s3 = "!"
      val partialString = genericCompose[String](_+s3, _+s2)
      assertEquals(s1 + s2 + s3, partialString(s1))
  }


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
