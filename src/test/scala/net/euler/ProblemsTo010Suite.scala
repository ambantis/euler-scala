package net.euler

import net.euler.ProblemsTo010._
import org.scalatest._

/**
 * 
 * User: Alexandros Bantis
 * Date: 1/17/13
 * Time: 11:25 PM
 */
class ProblemsTo010Suite extends FlatSpec {

  "A sum of Multiples 3 and 5 to 10 [using recursion]" should "equal 23" in {
    val result = getSumOfMultiplesA(3, 5, 10)
    assert(result === 23)
  }

  "A sum of Multiples 3 and 5 to 10 [using fold]" should "equal 23" in {
    val result = getSumOfMultiplesB(3, 5, 10)
    assert(result === 23)
  }

  "A sum of Multiples 3 and 5 to 10 [using for]" should "equal 23" in {
    val result = getSumOfMultiplesC(3, 5, 10)
    assert(result === 23)
  }

  "A sum of Multiples 3 and 5 to 10 [using alt fold]" should "equal 23" in {
    val result = getSumOfMultiplesD(3, 5, 10)
    assert(result === 23)
  }


  "The largest prime factor of 13195" should "equal 29" in {
    val result = largestPrimeFactor(13195)
    assert(result === 29)
  }


}
