package net.projecteuler

import net.euler.ProblemsTo010._
import org.scalatest._



/**
 * 
 * User: Alexandros Bantis
 * Date: 1/17/13
 * Time: 11:25 PM
 */
class ProblemsTo010Suite extends FlatSpec {

  "A sum of Multiples 3 and 5 to 10" should "equal 23" in {
    val result = getSumOfMultiplesTo(3, 5, 10)
    assert(result === 23)
  }

}
