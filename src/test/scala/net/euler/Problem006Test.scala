package net.euler

import org.scalatest.FlatSpec
import Problem006.sumSquareDiff

/**
 * 
 * User: Alexandros Bantis
 * Date: 2/26/13
 * Time: 1:51 PM
 */
class Problem006Test extends FlatSpec {

  "The difference between the sum of squares and sum from 1 to 10" should "equal 2,640" in {
    val expected = 2640
    val actual = sumSquareDiff(10)
    assert(actual === expected)
  }

}
