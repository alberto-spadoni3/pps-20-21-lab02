package u02

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test
import u02.Lab02_2a.{neg, negAsMethod, parity}
import u02.Lab02_2b.{p1, p2}

class lab02Test {
  @Test
  def parityTest() {
    assertEquals("Odd", parity(21))
    assertEquals("Even", parity(2446))
  }

  @Test
  def testNeg(): Unit = {
    val notEmpty = negAsMethod(_=="")
    assertTrue(notEmpty("hello"))
    val empty = negAsMethod(_!="")
    assertTrue(empty(""))
  }

  @Test
  //  test p1 val which represent a curriefFunType using val
  def testP1(): Unit = {
    assertTrue(p1(12)(13)(14))
    assertFalse(p1(3)(4)(3))
  }

  @Test
  //  test p2 val
  def testP2(): Unit = {
    assertTrue(p2(12,13,14))
    assertFalse(p2(3,4,3))
  }
}
