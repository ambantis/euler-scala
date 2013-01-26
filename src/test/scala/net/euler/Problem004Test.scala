package net.euler

import org.scalatest.FlatSpec
import net.euler.Problem004._

/**
 * 
 * User: Alexandros Bantis
 * Date: 1/26/13
 * Time: 12:18 PM
 */
class Problem004Test extends FlatSpec {

  "The largest palindromic number of two 2-digit numbers" should "equal 9009" in {
    val expected = 9009
    val result = maxPalindromeProduct(twoDigitNumbers)
    assert(result === expected)
  }

  "The largest palindromic number of two 3-digit numbers" should "equal 906609" in {
    val expected = 906609
    val result = maxPalindromeProduct(threeDigitNumbers)
    assert(result === expected)
  }

}
