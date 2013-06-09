package net.euler

/**
 * Goldbach's other conjecture
 *
 * It was proposed by Christian Goldbach that every odd composite number
 * can be written as the sum of a prime and twice a square.
 *
 *     9 = 7 +  2×1^2
 *    15 = 7 +  2×2^2
 *    21 = 3 +  2×3^2
 *    25 = 7 +  2×3^2
 *    27 = 19 + 2×2^2
 *    33 = 31 + 2×1^2

 * It turns out that the conjecture was false.
 *
 * What is the smallest odd composite that cannot be written
 * as the sum of a prime and twice a square?
 *
 * User: Alexandros Bantis
 * Date: 6/8/13
 * Time: 3:32 PM
 */
object Problem046 {

  def answer: Int = {
    def iter(n: Int): Int = {
      val goldbach =
        for {
          doubleSquare <- (1 to n).map(x => 2 * x * x).takeWhile(y => y < n)
          if primes.contains(n - doubleSquare)
        } yield doubleSquare
      if (goldbach.isEmpty) n
      else iter(next(n))
    }
    iter(next(1))
  }

  def next(x: Int): Int = {
    def loop(i: Int): Int = {
      if (!primes.contains(i)) i
      else loop(i+2)
    }
    loop(x+2)
  }

  val primes = primesTo(1000000)

  def primesTo(n: Int): Set[Int] = {
    val ceiling = Math.sqrt(n).toInt+1
    val sieve = (0 to n).toArray
    sieve(1) = 0
    for (i <- 2 to ceiling) {
      for (j <- 2 to n/i) {
        sieve(i*j) = 0
      }
    }
    def iter(acc: Set[Int], i: Int): Set[Int] = {
      if (i > n) acc
      else if (sieve(i) > 0) iter(acc + i, i+1)
      else iter(acc, i+1)
    }
    iter(Set(), 2)
  }
}
