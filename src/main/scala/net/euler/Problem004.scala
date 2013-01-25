package net.euler

/**
 * 
 * User: Alexandros Bantis
 * Date: 1/24/13
 * Time: 11:11 PM
 */
class Problem004 {

  val threeDigitNumbers = (100 to 999).toList

  def maxPalindromeProduct(numbers: List[Int]) = {
    val palindromes =
      for {
        a <- numbers
        b <- numbers
        value = a * b
        if (value.toString == value.toString.reverse)
      } yield value
    palindromes.max
  }

}
