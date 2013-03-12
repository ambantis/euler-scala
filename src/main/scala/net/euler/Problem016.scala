package net.euler

/**
 * Power digit sum
 *
 * 2**15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2**1000?
 *
 * User: Alexandros Bantis
 * Date: 3/10/13
 * Time: 12:45 AM
 */
object Problem016 {

  def bigNumberString(power: Int): String = BigInt(2).pow(power).toString()

  def sumOfDigits(exp: Int): Int = (0 /: bigNumberString(exp).toList.map(c => Integer.parseInt(c.toString)))(_ + _)

}
