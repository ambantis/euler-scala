package net.euler

/**
 * Smallest Multiple
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * User: Alexandros Bantis
 * Date: 1/29/13
 * Time: 8:07 PM
 */
object Problem005 {
  private def isDivisibleByAll(n: Int, top: Int): Boolean = (1 to top).forall(n % _ == 0)

  // these don't work so well with larger numbers
  private lazy val numbers: Stream[Int] = Stream.from(1)
  def findSmallestMultipleLazy(ceiling: Int): Int = {
    numbers.filter(isDivisibleByAll(_,ceiling))(0)
  }

  def findSmallestMultiple(ceiling: Int): Int = {
    def iter(n: Int): Int = if (isDivisibleByAll(n, ceiling)) n else iter(n+1)
    iter(1)
  }

}
