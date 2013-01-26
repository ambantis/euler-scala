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

  def isPrime(n: Long): Boolean = {
    def ceiling = math.sqrt(n.toDouble).toLong
    (2L to ceiling) forall (x => n % x != 0)
  }

  lazy val allPrimes: Stream[Long] = {
    def p(n: Long): Stream[Long] = (n #:: p(n+1)).filter(isPrime(_))
    p(2L)
  }

  def primeFactors(number: Long): List[Long] = {
    def iter(factors: List[Long], primes: Stream[Long], rem: Long): List[Long] =
      if (rem == 1) factors
      else if (rem % primes.head == 0) iter(primes.head :: factors, primes, rem / primes.head)
      else iter(factors, primes.tail, rem)
    if (isPrime(number)) List(1L) else iter(Nil, allPrimes, number)
  }
}
