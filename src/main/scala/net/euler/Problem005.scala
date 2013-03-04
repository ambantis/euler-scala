package net.euler

import scalaz._
import Scalaz._
import Tags._

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
    val factors = (2 to ceiling).map(primeFactors(_).mapValues(MaxVal)).reduce(_ |+| _)
    (1 /: factors.map(m => intPow(m._1, m._2)))(_ * _)
  }

  private def primeFactors(number: Int): Map[Int, Int] = {
    def iter(factors: Map[Int,Int], rem: Int, i: Int): Map[Int,Int] = {
      if (i > number) factors.filter(_._2 > 0).mapValues(MaxVal)
      else if (rem % i == 0) iter(factors - i + (i -> (factors(i)+1)), rem / i, i)
      else iter(factors, rem, i + 1)
    }
    iter((2 to number).map((_,0)).toMap, number, 2)
  }

  private def intPow(x: Int, y: Int): Int = {
    def iter(acc: Int, rem: Int): Int = if (rem == 0) acc else iter(acc * x, rem -1)
    if (y == 0) 1 else iter(1, y)
  }
}
