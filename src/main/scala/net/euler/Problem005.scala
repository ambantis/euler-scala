package net.euler

/**
 * Smallest Multiple
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * User: Alexandros Bantis
 * Date: 1/29/13
 * Time: 8:07 PM
 */
object Problem005 {

  def findSmallestMultiple(ceiling: Int): Int = {
    def primeFactors(number: Int): Map[Int, Int] = {
      def iter(factors: Map[Int,Int], rem: Int, i: Int): Map[Int,Int] = {
        if (i > number) factors
        else if (rem % i == 0) iter(factors - i + (i -> (factors(i)+1)), rem / i, i)
        else iter(factors, rem, i + 1)
      }
      iter((2 to ceiling).map((_,0)).toMap, number, 2)
    }
    val defaultMap = (2 to ceiling).map((_,0)).toMap
    val factors: Map[Int, Int] = (2 to ceiling).map(primeFactors(_)).foldRight(defaultMap)(mergeMaps(_, _))
    (1 /: factors.map(m => intPow(m._1, m._2)))(_ * _)
  }

  private def mergeMaps(xm: Map[Int, Int], ym: Map[Int, Int]): Map[Int,Int] = {
    def iter(acc: Map[Int,Int], other: Map[Int,Int], i: Int): Map[Int,Int] = {
      if (other.isEmpty) acc
      else iter(acc - i + (i -> math.max(acc(i), other(i))), other - i, i + 1)
    }
    iter(xm, ym, 2)
  }

  private def intPow(x: Int, y: Int): Int = {
    def iter(acc: Int, rem: Int): Int = {
      if (rem == 0) acc
      else iter(acc * x, rem -1)
    }
    if (y == 0) 1 else iter(1, y)
  }

  //  private lazy val allPrimes: Stream[Int] = {
  //    def p(n: Int): Stream[Int] = (n #:: p(n+1)).filter(isPrime(_))
  //    p(2)
  //  }
  //
  //  def primesTo20 = allPrimes.takeWhile(_ <= 20)

  //  private def isPrime(n: Int): Boolean = {
  //    def ceiling = math.sqrt(n).toInt
  //    (2 to ceiling) forall (x => n % x != 0)
  //  }


}
