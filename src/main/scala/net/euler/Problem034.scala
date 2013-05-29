package net.euler

/**
 * Digit Factorials
 *
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 *
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 *
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 *
 * User: Alexandros Bantis
 * Date: 5/28/13
 * Time: 7:00 PM
 */
object Problem034 {

  def fact(n: Int): Int = (1 to n).reduce((_ * _))
  def pow(base: Int, exp: Int): Long = (1 to exp).map(x => base).toList.reduce(_ * _)
  val fact9 = fact(9)

  def limit(i: Int): Int = if (pow(9,i) > fact9 * i) i else limit(i+1)

}
