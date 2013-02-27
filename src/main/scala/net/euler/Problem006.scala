package net.euler

/**
 * Sum square difference
 *
 * The sum of the squares of the first ten natural numbers is, 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is, (1 + 2 + ... + 10)^2 = 55^2^ = 3025

 * Hence the difference between the sum of the squares of the first ten natural numbers
 * and the square of the sum is 3025 − 385 = 2640. Find the difference between the sum of the squares
 * of the first one hundred natural numbers and the square of the sum.

 * User: Alexandros Bantis
 * Date: 2/26/13
 * Time: 1:34 PM
 */
object Problem006 {

  def sumSquareDiff(n: Int): Int = (1 to n).sum * (1 to n).sum - (1 to n).map(x => x * x).sum
}
