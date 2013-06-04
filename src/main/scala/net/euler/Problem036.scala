package net.euler

/**
 * Double-base palindromes
 *
 * The decimal number, 585 = 101001001 (binary), is palindromic in both cases.
 *
 * Find the sum of all numbers, less than one million, which are palindromic
 * in base 10 and base 2.
 *
 * User: Alexandros Bantis
 * Date: 6/4/13
 * Time: 8:27 AM
 */
object Problem036 {

  def palindromicSumTo(ceiling: Int): Long = {
    def iter(i: Int, acc: Long): Long = {
      if (i == ceiling) acc
      else if (isDoubleBasePalindrome(i)) iter(i+1, acc+i)
      else iter(i+1, acc)
    }
    iter(1, 0)
  }

  def isDoubleBasePalindrome(n: Int) = isPalindrome(n.toString) && isPalindrome(toBinary(n))

  def isPalindrome(s: String): Boolean = s == s.reverse

  def toBinary(n: Int): String = {
    def iter(acc: List[Int], rem: Int): String = {
      if (rem == 0) acc.reverse.mkString
      else iter(rem % 2 :: acc, rem / 2)
    }
    iter(Nil, n)
  }

}
