package net.euler

import scala.io.Source

/**
 * Largest project in a series
 *
 * Find the greatest product of five consecutive digits in the 1000-digit number.
 *
 * User: Alexandros Bantis
 * Date: 3/2/13
 * Time: 1:12 PM
 */
object Problem008 {
  val source = Source.fromURL(getClass.getResource("/problem008.txt")).toList.filter(_.isDigit).map(_.toString.toInt)

  def largestProduct(numbers: List[Int]): Int = {
    def iter(rem: List[Int], largest: Int): Int = {
      rem match {
        case n1 :: n2 :: n3 :: n4 :: n5 :: ns => iter(rem.tail, Math.max(largest, n1 * n2 * n3 * n4 * n5))
        case _ => largest
      }
    }
    iter(numbers, 0)
  }
}
