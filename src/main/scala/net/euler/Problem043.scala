package net.euler

/**
 * Sub-string divisibility
 *
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of
 * each of the digits 0 to 9 in some order, but it also has a rather interesting
 * sub-string divisibility property.
 *
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
 *
 *  d2d3d4=406 is divisible by 2
 *  d3d4d5=063 is divisible by 3
 *  d4d5d6=635 is divisible by 5
 *  d5d6d7=357 is divisible by 7
 *  d6d7d8=572 is divisible by 11
 *  d7d8d9=728 is divisible by 13
 *  d8d9d10=289 is divisible by 17
 *
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 *
 * User: Alexandros Bantis
 * Date: 6/7/13
 * Time: 11:30 PM
 */
object Problem043 {

  def answer = {
    def iter(acc: List[List[Int]], divisors: List[Int]): Long = {
      if (divisors.isEmpty) acc.map(x => x.mkString.toLong).filter(y => isPandigital(y)).sum
      else iter(grow(acc, divisorRule(divisors.head)), divisors.tail)
    }
    iter(initialPair, List(2,3,5,7,11,13, 17))
  }

  def initialPair: List[List[Int]] =
    for {
      a <- (1 to 9).toList
      b <- 0 to 9
      c <- 0 to 9
    } yield a :: b :: c :: Nil

  def grow(acc: List[List[Int]], test: (Int, Int, Int) => Boolean): List[List[Int]] = {
    for {
      base <- acc
      a = base.reverse.tail.head
      b = base.reverse.head
      c <- 0 to 9
      if test(a,b,c) && unique(base, c)
    } yield base ++ List(c)
  }

  def unique(base: List[Int], x: Int): Boolean = {
    (x :: base).distinct.length == base.length + 1
  }

  def divisorRule(by: Int): (Int, Int, Int) => Boolean =
    (x: Int, y: Int, z: Int) => List(x,y,z).mkString.toInt % by == 0

  def isPandigital(n: Long): Boolean = {
    def iter(rem: List[Int], i: Int): Boolean = {
      if (rem.isEmpty) true
      else if (rem.head != i) false
      else iter(rem.tail, i+1)
    }
    iter(n.toString.toList.sorted.map(x => x.toString.toInt), 0)
  }
}
