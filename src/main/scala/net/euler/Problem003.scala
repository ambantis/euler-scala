package net.euler

/**
 * Largest Prime Factor
 *
 * The prime factors of 13195 are 5, 7, 13 and 29. What is the largest prime factor of the number 600851475143
 *
 * User: Alexandros Bantis
 * Date: 1/24/13
 * Time: 11:11 PM
 */
object Problem003 {

  lazy val primes: Stream[Int] = 2 #:: Stream.from(3).filter(i =>
    primes.takeWhile(j => j * j <= i).forall(i % _ > 0))

  def primeFactors(n: Long): List[Int] = {
    val ceiling = Math.sqrt(n)
    primes.view.takeWhile(_ < ceiling).filter(n % _ == 0).toList
  }

  // runs faster but is more verbose
  //  private def roughRoot(number: Long) = {
  //    def iter(i: Long): Long = if (i * i > number) i else iter(i + 1)
  //    iter(2L)
  //  }
  //
  //  def primeFactors(number: Long): List[Long] = {
  //    val ceiling = roughRoot(number)
  //    def iter(factors: List[Long], rem: Long, i: Long): List[Long] = {
  //      if (i == ceiling) factors
  //      else if (rem % i == 0) iter(i :: factors, rem / i, i)
  //      else iter(factors, rem, i + 1)
  //    }
  //    iter(List(1L), number, 2L)
  //  }


  //  runs very slowly
  //  private def isPrime(n: Long): Boolean = {
  //    def ceiling = math.sqrt(n.toDouble).toLong
  //    (2L to ceiling) forall (x => n % x != 0)
  //  }
  //
  //  lazy val allPrimes: Stream[Long] = {
  //    def p(n: Long): Stream[Long] = (n #:: p(n+1)).filter(isPrime(_))
  //    p(2L)
  //  }
  //
  //  def lazyPrimeFactors(number: Long): List[Long] = {
  //    def iter(factors: List[Long], primes: Stream[Long], rem: Long): List[Long] =
  //      if (rem == 1) factors
  //      else if (rem % primes.head == 0) iter(primes.head :: factors, primes, rem / primes.head)
  //      else iter(factors, primes.tail, rem)
  //    if (isPrime(number)) List(1L) else iter(Nil, allPrimes, number)
  //  }

}
