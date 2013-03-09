package net.euler

import scala.util.control.Breaks._

/**
 * Special Pythagorean triplet
 *
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which a**2 + b**2 = c**2.
 * There exists exactly one Pythagorean triplet for which a + b + c =  1000. Find the product abc

 * User: Alexandros Bantis
 * Date: 3/3/13
 * Time: 9:38 AM
 */
object Problem009 {

  def pythagoreanTripleP(): Int = {
    var product = 0
    breakable {
      for (i <- 1 to 998) {
        for (j <- 1 to 998) {
          for (k <- 1 to 998) {
            if (i + j + k == 1000 && isTripleP(i, j, k)) {
              product = i * j * k
              break()
            }
          }
        }
      }
    }
    product
  }

  private def isTripleP(x: Int, y: Int, z: Int): Boolean = {
    val max = Math.max(x, Math.max(y, z))
    if (max == x) x*x == y*y + z*z
    else if (max == y) y*y == x*x + z*z
    else if (max == z) z*z == x*x + y*y
    else false
  }

  def pythagoreanTripleF(): Int = {
    val product: IndexedSeq[Int] =
      for {
        x <- 1 to 998
        y <- 1 to 998
        z <- 1 to 998
        if (x + y + z == 1000 && x < y && y < z && isTripleF(x, y, z))
      } yield (x * y * z)
    product.head
  }

  private def isTripleF(x: Int, y: Int, z: Int): Boolean = (x, y, z) match {
    case (a, b, c) => c*c == a*a + b*b
    case _ => false
  }
}
