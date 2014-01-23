package net.euler

/**
 * Largest Palindrome Product
 *
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99. Find the largest palindrome made
 * from the product of two 3-digit numbers.
 *
 * User: Alexandros Bantis
 * Date: 1/24/13
 * Time: 11:11 PM
 */
object Problem004 {

//  val twoDigitNumbers = (1 to 99).toList
//  val threeDigitNumbers = (100 to 999).toList

//  def maxPalindromeProduct(numbers: List[Int]): Int = {
//    val palindromes =
//      for {
//        x <- numbers
//        y <- numbers
//        value = x * y
//        if (value.toString == value.toString.reverse)
//      } yield value
//    palindromes.max
//  }

  val divisors = (100 to 999).toList
  val ceiling = 999 * 999
  def isPalindrome(x: Int): Boolean = x.toString == x.toString.reverse
  def isProduct(n: Int): Boolean = divisors.exists { x => n % x == 0 && divisors.contains(n/x) }
  def maxPalindrome: Int = (ceiling to 1 by -1).dropWhile { x =>
    !(isPalindrome(x) && isProduct(x))
  } head

}
