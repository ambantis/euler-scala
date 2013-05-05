package net.euler

/**
 * Digit fifth powers
 *
 * Surprisingly there are only three numbers that can be written as the sum of
 * fourth powers of their digits:
 *
 *           1634 = 1**4 + 6**4 + 3**4 + 4**4
 *           8208 = 8**4 + 2**4 + 0**4 + 8**4
 *           9474 = 9**4 + 4**4 + 7**4 + 4**4
 *
 * As 1 = 1**4 is not a sum it is not included.
 *
 * The sum of these numbers is 1634 + 9474 = 19316.
 *
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 *
 * User: Alexandros Bantis
 * Date: 5/4/13
 * Time: 7:36 PM
 */

object Problem030 {

  def digitFourthPowers(n: Int): List[Int] = {
    def f(n: Int): Int = n.toString.toList.map(x => math.pow(x-'0',4).toInt).sum
    for {
      x <- (2 to n).toList
      if (x == f(x))
    } yield x
  }

  def forDigitFifthPowers(n: Int): List[Int] = {
    def f(n: Int): Int = n.toString.toList.map(x => math.pow(x-'0',5).toInt).sum
    for {
      x <- (2 to n).toList
      if (x == f(x))
    } yield x
  }

  def digitFifthPowers(n: Long): List[Long] = {
    def f(n: Long): Long = {
      def loop(acc: Long, rem: String): Long = {
        if (rem.isEmpty) acc
        else loop(acc + math.pow(rem.head-'0',5).toLong, rem.tail)
      }
      loop(0, n.toString)
    }
    def iter(acc: List[Long], i: Long): List[Long] = {
      if (i > n) acc.reverse
      else f(i) match {
        case p if (p == i) => iter(p :: acc, i+1)
        case _             => iter(acc, i+1)
      }
    }
    iter(Nil, 2)
  }
}
