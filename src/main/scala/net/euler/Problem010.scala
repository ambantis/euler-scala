package net.euler

/**
 * Summation of primes
 *
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17
 *
 * Find the sum of all the primes below two million
 *
 * User: Alexandros Bantis
 * Date: 3/3/13
 * Time: 11:07 AM
 */
object Problem010 {

  def primesTo(n: Int): List[Int] = {
    val ceiling = Math.sqrt(n).toInt + 1
    val sieve = (0 to n).toArray
    sieve(1) = 0
    for (i <- 2 to ceiling) {
      for (j <- 2 to n/i) {
        sieve(i*j) = 0
      }
    }
    def iter(acc: List[Int], i: Int): List[Int] = {
      if (i > n) acc
      else if (sieve(i) > 0) iter(i :: acc, i+1)
      else iter(acc, i+1)
    }
    iter(Nil, 2)
  }

  def sumPrimesTo(n: Int) = (0L /: primesTo(n))(_ + _)

  // functional version runs very slowly
  //  def primesTo(n: Int): Vector[Int] = {
  //    val ceiling = Math.sqrt(n).toInt + 1
  //    def iter(numbers: Vector[Int], i: Int): Vector[Int] = {
  //      val sieve = (i*2 to n by i).toList
  //      if (i == ceiling) numbers
  //      else iter(numbers.diff(sieve), i+1)
  //    }
  //    iter((2 to n).toVector, 2)
  //  }

}
