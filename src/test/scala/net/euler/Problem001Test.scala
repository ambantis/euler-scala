package net.euler

import net.euler.Problem001._
import org.scalatest._

/**
 * 
 * User: Alexandros Bantis
 * Date: 1/24/13
 * Time: 11:06 PM
 */
class Problem001Test extends FlatSpec {

  "A sum of natural numbers divisible by 3 and 5 less than 10" should "equal 23" in {
    val result = lazySumOfMultiples3And5To(10)
    assert(result === 23)
  }

}
