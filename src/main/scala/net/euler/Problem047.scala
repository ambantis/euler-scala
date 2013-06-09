package net.euler

/**
 * Distinct prime factors
 *
 * The first two consecutive numbers to have two distinct prime factors are:
 *     14 = 2 × 7
 *     15 = 3 × 5
 *
 * The first three consecutive numbers to have three distinct prime factors are:
 *     644 = 2² × 7 × 23
 *     645 = 3 × 5 × 43
 *     646 = 2 × 17 × 19.
 *
 * Find the first four consecutive integers to have four distinct prime factors.
 * What is the first of these numbers?
 *
 * User: Alexandros Bantis
 * Date: 6/8/13
 * Time: 10:41 PM
 */
object Problem047 {

  def answer = {
    def iter(i: Long): Long = {
      if (factors(i).length == 4 && factors(i-1).length == 4 && factors(i-2).length == 4 && factors(i-3).length == 4)
        i-3
      else
        iter(i+1)
    }
    iter(4)
  }

  lazy val primes: Stream[Int] = 2 #:: Stream.from(3).filter(i =>
    primes.takeWhile(j => j * j <= i).forall(i % _ > 0))

  def factors(n: Long): List[Int] = primes.view.takeWhile(_ < n).filter(n % _ == 0).toList

}
