package net.euler

/**
 * The prime 41, can be written as the sum of six consecutive primes:
 *     41 = 2 + 3 + 5 + 7 + 11 + 13
 *
 * This is the longest sum of consecutive primes that adds to a prime below 100.
 *
 * The longest sum of consecutive primes below one-thousand that adds to a prime,
 * contains 21 terms, and is equal to 953.
 *
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?

 * User: Alexandros Bantis
 * Date: 6/9/13
 * Time: 7:07 AM
 */
object Problem050 {

  val max = 1000000

  val primes: Set[Long] = primesTo(max)

  val cumulativeSum: List[(Long, Int, Long)] = {
    def iter(acc: List[(Long, Int, Long)], rem: List[Long]): List[(Long, Int, Long)] = {
      if (acc.head._3 + rem.head > max) acc.reverse
      else iter ((rem.head, acc.head._2 + 1, acc.head._3 + rem.head) :: acc, rem.tail)
    }
    iter(List((2, 1, 2)), primes.toList.sorted.tail)
  }

  def max(a: (Long, Int), b: (Long, Int)): (Long, Int) = {
    if (a._2 > b._2) a
    else b
  }

  def primeSum(ceiling: (Long, Int, Long), rem: List[(Long, Int, Long)]): Option[(Long, Int)] = {
    if (rem.isEmpty)
      None
    else if (primes.contains(ceiling._3 - rem.head._3))
      Some((ceiling._3 - rem.head._3, ceiling._2 - rem.head._2))
    else
      primeSum(ceiling, rem.tail)
  }

  def answer: (Long, Int) = {
    def iter(acc: (Long, Int), rem: List[(Long, Int, Long)]): (Long, Int) = {
      if (rem.isEmpty) acc
      else if (primes.contains(rem.head._3)) {
        iter(max((rem.head._3, rem.head._2), acc), rem.tail)
      }
      else primeSum(rem.head, cumulativeSum.takeWhile(x => x._1 < rem.head._1)) match {
        case None => iter(acc, rem.tail)
        case Some(next) => {
          iter(max(next,acc), rem.tail)
        }
      }
    }
    iter((0,0), cumulativeSum)
  }

  def primesTo(n: Int): Set[Long] = {
    val ceiling = Math.sqrt(n).toInt+1
    val sieve = (0 to n).toArray
    sieve(1) = 0
    for (i <- 2 to ceiling) {
      for (j <- 2 to n/i) {
        sieve(i*j) = 0
      }
    }
    def iter(acc: Set[Long], i: Int): Set[Long] = {
      if (i > n) acc
      else if (sieve(i) > 0) iter (acc + i, i+1)
      else iter(acc, i+1)
    }
    iter(Set(), 2)
  }




}
