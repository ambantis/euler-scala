package net.euler

/**
 * Factorial digit sum
 *
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 *
 * User: Alexandros Bantis
 * Date: 3/14/13
 * Time: 11:02 PM
 */
object Problem020 {

  def fact(n: Int): BigInt = (BigInt(1) to BigInt(n)).reduce(_ * _)

  val factorialSumOfDigitsFor100 = fact(100).toString().toList.map(_.asDigit).sum
}
