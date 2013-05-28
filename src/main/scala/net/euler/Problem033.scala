package net.euler

import scalaz._
import Scalaz._
import Tags._


/**
 * Digit Cancelling Fractions
 *
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting
 * to simplify it may incorrectly believe that 49/98 = 4/8, which is correct,
 * is obtained by cancelling the 9s.
 *
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 *
 * There are exactly four non-trivial examples of this type of fraction, less than one in value,
 * and containing two digits in the numerator and denominator.
 *
 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 *
 * User: Alexandros Bantis
 * Date: 5/27/13
 * Time: 8:21 PM
 */
object Problem033 {

  def findFractions(): List[(Int,Int)] = {
    val numbers: List[Int] = (11 to 99).toList.filterNot(x => x % 10 == 0)
    val fractions: List[(Int,Int)] =
      for {
        numerator <-numbers
        denominator <- numbers
        if (numerator < denominator)
        n1 = numerator.toString.map(x => x.toString.toInt).head
        n2 = numerator.toString.map(x => x.toString.toInt).tail.head
        d1 = denominator.toString.map(x => x.toString.toInt).head
        d2 = denominator.toString.map(x => x.toString.toInt).tail.head
        if (n2 == d1 && (numerator * 1.0)/denominator == (n1*1.0)/d2)
     } yield (numerator,denominator)
    fractions
  }

  def primeFactors(number: Int): Map[Int, Int] = {
    def iter(factors: Map[Int,Int], rem: Int, i: Int): Map[Int,Int] = {
      if (i > number) factors.filter(_._2 > 0).mapValues(MaxVal)
      else if (rem % i == 0) iter(factors - i + (i -> (factors(i)+1)), rem / i, i)
      else iter(factors, rem, i + 1)
    }
    iter((2 to number).map((_,0)).toMap, number, 2)
  }


  val numerator = findFractions().map(x => x._1)
  val denominator = findFractions().map(x => x._2)

  val numFactors = numerator.map(x => primeFactors(x)).reduce(_ |+| _)
  val denomFactors = denominator.map(x => primeFactors(x)).reduce(_ |+| _)

}
