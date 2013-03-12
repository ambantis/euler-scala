package net.euler

import io.Source

/**
 * Number letter counts
 *
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total. If all the
 * numbers from 1 to 1000 (one thousand) inclusive were written out in words,
 * how many letters would be used?
 * 
 * User: Alexandros Bantis
 * Date: 3/11/13
 * Time: 2:18 PM
 */
object Problem017 {

  val lengths: Map[Int,Int] = {
    val s = Source.fromURL(this.getClass.getResource("/problem017.txt")).getLines().toList.map(line => line.split(","))
    val k = s.map(x => x(0).toInt)
    val v = s.map(x => x(1).length)
    k.zip(v).toMap + (0 -> 0)
  }

  def spelledOutLength(n: Int): Int = {
    def basePow(exp: Int) = if (exp == 0) 1 else (1 to exp).map(x => 10).reduce(_ * _)
    def hasAnd(n: Int): Boolean = n > 100 && n % 100 > 0
    def iter(acc: Int, rem: Int): Int = {
      val exp = rem.toString.length - 1
      val part = (rem / basePow(exp)) * basePow(exp)
      if (lengths.contains(rem)) acc + lengths(rem)
      else if (lengths.contains(part)) iter(acc + lengths(part), rem - part)
      else throw new IllegalArgumentException("Cannot parse " + n)
    }
    if (hasAnd(n)) iter(3, n) else iter(0, n)
  }

  def spelledOutLengthTo(ceiling: Int) = (1 to ceiling).map(x => spelledOutLength(x)).sum
}
