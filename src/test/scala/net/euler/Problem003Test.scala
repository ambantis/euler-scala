package net.euler

import org.scalatest.FlatSpec
import net.euler.Problem003._

/**
 * 
 * User: Alexandros Bantis
 * Date: 1/25/13
 * Time: 7:04 PM
 */
class Problem003Test extends FlatSpec {

  "The greatest prime factor of 13195" should "equal 29" in {
    val expected: Long = 29L
    val result = primeFactors(13195).head
    assert(result === expected)
  }

  "The greatest prime factor of 600851475143" should "equal 6857" in {
    val expected: Long = 6857L
    val result = primeFactors(600851475143L).head
    assert(result === expected)
  }

}
