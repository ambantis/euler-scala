package net.euler

import org.scalatest.FlatSpec
import net.euler.Problem005.findSmallestMultiple

/**
 * 
 * User: Alexandros Bantis
 * Date: 1/29/13
 * Time: 8:22 PM
 */
class Problem005Test extends FlatSpec {

  "The largest number evenly divisible by the numbers 1-10" should "equal" in {
    val expected = 2520
    val actual = findSmallestMultiple(10)
    assert(actual == expected)
  }

}
