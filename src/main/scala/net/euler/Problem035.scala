package net.euler

/**
 * Circular primes
 *
 * The number 197 is called a circular prime because all rotations of the digits: 197, 971, and 719
 * are themselves prime.
 *
 * There are thirteen such primes below 100: 2, 3, 5 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 *
 * How many circular primes are there below one million?
 *
 *   Proposed solution:
 *   1. iterate through the set 2 - 999,999
 *   2. is the next number prime?
 *   3. if yes, then do steps 4-8
 *   4. convert the number to a list of integers
 *   5. generate all
 *
 * User: Alexandros Bantis
 * Date: 6/1/13
 * Time: 9:02 AM
 */
object Problem035 {

  def circularPrimes(limit: Int): List[Int] = {
    val primes = primesTo(limit)
    def iter(acc: List[Int], i: Int): List[Int] = {
      if (i == limit) acc
      else if (primes.contains(i) && circulars(i).forall(x => primes.contains(x))) iter(i :: acc, i+1)
      else iter(acc, i+1)
    }
    iter(Nil, 2)
  }

  def circulars(n: Int): List[Int] = generateCircularList(n).map(x => x.map(y => y._1)).map(z => listToInt(z))

  def circulate(n: List[(Int, Int)]): List[(Int, Int)] = n.tail ++ List(n.head)

  def intToListWithIndex(x: Int): List[(Int, Int)] = x.toString.map(x => x.toString.toInt).toList.zipWithIndex

  def listToInt(ns: List[Int]): Int =
    (0 /: ns.reverse.zipWithIndex.map(x => x._1 * intPow(10, x._2)))(_ + _)

  def generateCircularList(n: Int): List[List[(Int, Int)]] = {
    val first = intToListWithIndex(n)
    def isFirst(n: List[(Int,Int)]): Boolean = n.head._2 == 0
    def iter(acc: List[List[(Int, Int)]], next: List[(Int, Int)]): List[List[(Int, Int)]] = {
      if (isFirst(next)) acc
      else iter(next :: acc, circulate(next))
    }
    iter(first :: Nil, circulate(first))
  }

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
      else if (sieve(i) > 0) iter (acc + i, i+1)
      else iter(acc, i+1)
    }
    iter(Set(), 2)
  }

  def intPow(x: Int, y: Int): Int = {
    def iter(acc: Int, rem: Int): Int = {
      if (rem == 0) acc
      else iter(acc * x, rem-1)
    }
    if (y == 0) 1 else iter (1, y)
  }

}
