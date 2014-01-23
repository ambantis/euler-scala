package net.euler

/**
 * 10001st Prime
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10,001st prime number?
 *
 * User: Alexandros Bantis
 * Date: 3/2/13
 * Time: 12:19 PM
 */
object Problem007 {

  lazy val primes: Stream[Int] = 2 #:: Stream.from(3).filter { i =>
    primes.takeWhile(x => x*x <= i).forall(i % _ > 0)
  }
  def nthPrime(n: Int): Int = primes.drop(n-1).take(1).toList.head
//  val primes: Vector[Int] = {
//  val n = 2000000
//  val ceiling = Math.sqrt(n).toInt + 1
//    val sieve = (0 to n).toArray
//    sieve(1) = 0
//    for (i <- 2 to ceiling) {
//      for (j <- 2 to n/i) {
//        sieve(i*j) = 0
//      }
//    }
//    def iter(acc: List[Int], i: Int): List[Int] = {
//      if (i > n) acc
//      else if (sieve(i) > 0) iter(i :: acc, i+1)
//      else iter(acc, i+1)
//    }
//    iter(Nil, 2).reverse.toVector
//  }

  // functional version runs very slowly
  //  def isPrime(n: Long): Boolean = {
  //    def ceiling = math.sqrt(n.toDouble).toLong
  //    (2L to ceiling).forall(x => n % x != 0)
  //  }
  //
  //  private def nextPrime(prime: Int): Int = {
  //    def iter(i: Int): Int = if (isPrime(i)) i else iter(i+2)
  //    iter(prime+1)
  //  }
  //
  //  def nthPrime(n: Int): Int = {
  //    def iter(i: Int, prime: Int): Int = if (i == n) prime else iter(i+1, nextPrime(prime))
  //    iter(1, 2)
  //  }
}
