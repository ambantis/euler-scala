package net.euler

import net.euler.Problem002._
import org.scalatest._

/**
 * 
 * User: Alexandros Bantis
 * Date: 1/24/13
 * Time: 10:34 PM
 */
class Problem002Test extends FlatSpec {

  "A sum of all even fibonnaci numbers less than 100" should "equal 44" in {
    val result = sumEvenFibonacci(100)
    assert(result === 44)
  }
}
