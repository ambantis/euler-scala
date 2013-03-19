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

  def pythagoreanTriple(ceiling: Int): Int = {
    val product: IndexedSeq[Int] =
      for {
        c <- 1 to ceiling - 2
        b <- 1 to ceiling - 1 - c
        a = ceiling - b - c
        if (a*a + b*b == c*c)
      } yield a * b * c
    product.head
  }

  def pythagoreanTripleProceduralVersion(ceiling: Int): Int = {
    var product = 0
    breakable {
      for (c <- 1 to ceiling-2) {
        for (b <- 1 to ceiling-1-c; a = ceiling - b - c) {
          if (a*a + b*b == c*c) {
            product = a * b * c
            break()
          }
        }
      }
    }
    product
  }
}
