package net.euler

/**
 * Multiples of 3 and 5
 *
 * If we list all the natural numbers below 10 that are multiples of 3 and 5, we get 3, 5, 6, 9.
 * The sum of these multiples is 23. Find the sum of all the multiples of 3 and 5 below 1000.
 *
 * User: Alexandros Bantis
 * Date: 1/23/13
 * Time: 9:08 PM
 */
object Problem001 {

  def sumOfMultiplesWithFold(x: Int, y: Int, limit: Int): Int =
    (0 until limit).filter(a => a % x == 0 || a % y == 0).fold(0)(_ + _)

  def sumOfMultiplesWithFor(x: Int, y: Int, limit: Int): Int =
    (0 /: (for (a <- (0 until limit) if (a % x == 0 || a % y == 0)) yield a))(_ + _)

  private lazy val multiplesOfThreeAndFive: Stream[Int] = Stream.from(1).filter(m => m % 3 == 0 || m % 5 == 0)

  def lazySumOfMultiples3And5To(limit: Int) = (0 /: multiplesOfThreeAndFive.takeWhile(_ < limit))(_ + _)

}
