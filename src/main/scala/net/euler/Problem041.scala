package net.euler

/**
 * Pandigital prime
 *
 * We shall say that an n-digit number is pandigital if it makes use of all
 * the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital
 * and is also prime.
 *
 * What is the largest n-digit pandigital prime that exists?

 * User: Alexandros Bantis
 * Date: 6/7/13
 * Time: 7:44 PM
 */
object Problem041 {

  val maxPandigitalPrime: Int = {
    def iter(i: Int): Int = {
      if (i < 1234567) 0
      else if (isPandigital(i) && (3L to i by 2).takeWhile(x => x * x <= i).forall(i % _ != 0)) i
      else iter(i-2)
    }
    iter(9876543)
  }

  def isPandigital(n: Int): Boolean = {
    def iter(rem: List[Int], i: Int): Boolean = {
      if (rem.isEmpty) true
      else if (rem.head != i) false
      else iter(rem.tail, i+1)
    }
    iter(n.toString.toList.sorted.map(x => x.toString.toInt), 1)
  }
}
