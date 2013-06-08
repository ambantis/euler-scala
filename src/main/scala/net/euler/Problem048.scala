package net.euler

/**
 * Self powers
 *
 * The series, 1**1 + 2**2 + 3**3 + 4**4 + ... * 10**10 = 10405071317
 *
 * Find the last ten digits of the series, 1**1 + 2**2 + ... + 1000**1000.
 *
 * User: Alexandros Bantis
 * Date: 6/7/13
 * Time: 7:16 PM
 */
object Problem048 {

  def solution(ceiling: Int): Long = (0L /: (1 to ceiling).map(x => selfPower(x)))(_ + _)

  def selfPower(n: Int): Long = {
    def truncate(n: Long, digits: Int): Long = n.toString.toList.takeRight(digits).mkString.toLong
    def iter(acc: Long, i: Int): Long = {
      if (i == n) acc
      else iter(truncate(acc * n, 10), i+1)
    }
    iter(n, 1)
  }

}
