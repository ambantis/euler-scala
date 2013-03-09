package net.euler

import io.Source

/**
 * Large sum
 *
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 *
 * User: Alexandros Bantis
 * Date: 3/8/13
 * Time: 4:42 PM
 */
object Problem013 {
  val largeSum = Source.fromURL(getClass.getResource("/problem013.txt")).getLines().map(p => BigInt(p)).sum

  val firstTenDigits = largeSum.toString().substring(0,10)
}
