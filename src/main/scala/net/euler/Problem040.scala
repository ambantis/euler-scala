package net.euler

/**
 * Champernowne's constant
 *
 * An irrational decimal fraction is created by concatenating the positive integers:
 *
 *     0.123456789 10 11 12 13 14 15 16 17 18 19 20 21 ...
 *       123456789 10 11 12 13 14 15 16 17 18 19 20 21
 *       123456789 10 11 21 31 41 51 61 71 81 91 02 12
 *       123456789011121314151617181910212
 *       123456789101112131415161718192021
 *       123456789101112131415161718191011
 *
 *
 * It can be seen that the 12th digit of the fractional part is 1.
 *
 * If dn represents the nth digit of the fractional part, find the value of the following expression.
 *
 *     d1 * d10 * d100 * d1000 * d10000 * d100000 * d1000000
 *
 * User: Alexandros Bantis
 * Date: 6/7/13
 * Time: 12:28 AM
 */
object Problem040 {

  val answer = d(1) * d(10) * d(100) * d(1000) * d(10000) * d(100000) * d(1000000)

  def d(ceiling: Int): Int = {
    def champList(n: Int): List[Int] = n.toString.toList.map(x => x.toString.toInt)
    def iter(i: Int, champ: List[Int], currChamp: Int): Int = {
      if (i == ceiling) champ.head
      else if (champ.tail.isEmpty) iter(i+1, champList(currChamp+1), currChamp+1)
      else iter(i+1, champ.tail, currChamp)
    }
    if (ceiling < 10) ceiling
    else iter(10, List(1,0), 10)
  }

}
