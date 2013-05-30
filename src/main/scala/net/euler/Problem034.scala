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

  def digitFactorials() = {
    def sumOfFact(n: Long): Long = (0L /: numToList(n).map(x => fact(x)))(_ + _)
    def numToList(n: Long): List[Long] = n.toString.map(x => x.toString.toLong).toList
    val ceiling = pow(10, limit)
    def iter(i: Long, acc: Long): Long = {
      if (i > ceiling) acc
      else if (i == sumOfFact(i)) iter(i+1, acc+i)
      else iter(i+1, acc)
    }
    iter(3,0)
  }

  def fact(n: Long): Long =
    if (n == 0) 1
    else (1L to n).reduce(_   * _)
  def pow(base: Int, exp: Int): Long = (1 to exp).map(x => base).toList.reduce(_ * _)
  val fact9 = fact(9)

  val limit: Int = {
    def iter(i: Int): Int = {
      if (pow(9,i) > fact9 * i) i
      else iter(i+1)
    }
    iter(1)
  }
}
