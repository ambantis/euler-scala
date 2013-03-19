package net.euler

/**
 * Amicable numbers
 *
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n). If d(a) = b and d(b) = a, where a != b,
 * then a and b are an amicable pair and each of a and b are called amicable
 * numbers.
 *
 * e.g., the proper divisors of 220 = {1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110}
 * proper divisors of 284 = {1, 2, 4, 71, 142}; so d(284) = 220
 *
 * Evaluate the sum of all the amicable numbers under 10,000
 * 
 * User: Alexandros Bantis
 * Date: 3/18/13
 * Time: 6:52 PM
 */

object Problem021 {

  def amicableSumTo(n: Int) = amicable(n).map(p => p._1 + p._2).sum


  def amicable(n: Int) = {
    val pairs =
      for {
        a <- 2 until n
        b = d(a)
        if (a < b && d(b) == a)
      } yield (a, b)
    pairs
  }

  def d(n: Int) = {
    val pairs =
      for {
        a <- (2 to Math.sqrt(n).toInt)
        if (n % a == 0)
        b = n / a
      } yield a + b
    pairs.sum + 1
  }

}
