package net.euler

import net.euler.Stopwatch._
import net.euler.Problem001._
import net.euler.Problem002._
import net.euler.Problem003._
import net.euler.Problem004._
import net.euler.Problem005._

/**
 * 
 * User: Alexandros Bantis
 * Date: 1/26/13
 * Time: 8:34 PM
 */
object Main {

  def main(args: Array[String]) {

    val stopwatch001 = new Stopwatch()
    val sumMultiplesOutput: Int = lazySumOfMultiples3And5To(1000)
    val sumMultiplesTime = stopwatch001.elapsedTime()
    println("Problem #001")
    println("============")
    print("The sum of all the multiples of 3 or 5 below 1000 = " + sumMultiplesOutput)
    println(" with a time of " + sumMultiplesTime + " seconds\n")

    val stopwatch002 = new Stopwatch()
    val sumEvenFiboNumbersOutput: Int = sumEvenFibonacci(4000000)
    val sumEvenFiboNumbersTime = stopwatch002.elapsedTime()
    println("Problem #002")
    println("============")
    print("The sum of even Fibonacci numbers that do not exceed 4 million = " + sumEvenFiboNumbersOutput)
    println(" with a time of " + sumEvenFiboNumbersTime + " seconds\n")

    val stopwatch003a = new Stopwatch()
    val lazyLargestPrimeFactorOutput: Long = lazyPrimeFactors(600851475143L).head
    val lazyLargestPrimeFactorTime = stopwatch003a.elapsedTime()
    println("Problem #003a")
    println("============")
    print("The largest prime factor of 600851475143 (LAZY) = " + lazyLargestPrimeFactorOutput)
    println(" with a time of " + lazyLargestPrimeFactorTime + " seconds\n")

    val stopwatch003b = new Stopwatch()
    val largestPrimeFactorOutput: Long = primeFactors(600851475143L).head
    val largestPrimeFactorTime = stopwatch003b.elapsedTime()
    println("Problem #003b")
    println("============")
    print("The largest prime factor of 600851475143 (REG) = " + largestPrimeFactorOutput)
    println(" with a time of " + largestPrimeFactorTime + " seconds\n")

    val stopwatch004 = new Stopwatch()
    val maxPalindromeProductOutput: Int = maxPalindromeProduct(threeDigitNumbers)
    val maxPalindromeProductTime = stopwatch004.elapsedTime()
    println("Problem #004")
    println("============")
    print("The largest palindrome made from the product of two 3-digit numbers is = " + maxPalindromeProductOutput)
    println(" with a time of " + maxPalindromeProductTime + " seconds\n")

    val stopwatch005 = new Stopwatch()
    val findSmallestMultipleOutput: Int = findSmallestMultiple(20)
    val findSmallestMultipleTime = stopwatch005.elapsedTime()
    println("Problem #005")
    println("============")
    print("The smallest even multiple of all numbers 1-20 is = " + findSmallestMultipleOutput)
    println(" with a time of " + findSmallestMultipleTime + " seconds\n")







  }
}
