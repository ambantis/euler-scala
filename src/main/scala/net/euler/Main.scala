package net.euler

import net.euler.Problem001.lazySumOfMultiples3And5To
import net.euler.Problem002.sumEvenFibonacci
import net.euler.Problem003.primeFactors
import net.euler.Problem004.{maxPalindromeProduct,threeDigitNumbers}
import net.euler.Problem005.findSmallestMultiple
import net.euler.Problem006.sumSquareDiff
import net.euler.Problem007.primes
import net.euler.Problem008.{largestProduct, source}
import net.euler.Problem009.{pythagoreanTripleP, pythagoreanTripleF}
import net.euler.Problem010.primesTo
import net.euler.Problem011.maxAll
import net.euler.Problem012.getNaturalNumbersWith
import net.euler.Problem013.firstTenDigits
import net.euler.Problem014.collatz
import net.euler.Problem015.lattice
import net.euler.Problem016.sumOfDigits
import net.euler.Problem017.spelledOutLengthTo

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

    val stopwatch003 = new Stopwatch()
    val largestPrimeFactorOutput: Long = primeFactors(600851475143L).head
    val largestPrimeFactorTime = stopwatch003.elapsedTime()
    println("Problem #003")
    println("============")
    print("The largest prime factor of 600851475143 = " + largestPrimeFactorOutput)
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

    val stopwatch006 = new Stopwatch()
    val sumSquareDiffOutput: Int = sumSquareDiff(100)
    val sumSquareDiffTime = stopwatch006.elapsedTime()
    println("Problem #006")
    println("============")
    print("The sum square difference from 1 to 100 is = " + sumSquareDiffOutput)
    println(" with a time of " + sumSquareDiffTime + " seconds\n")

    val stopwatch007 = new Stopwatch()
    val primeNum10001 = primes(10000)
    val primeNum10001Time = stopwatch007.elapsedTime()
    println("Problem #007")
    println("============")
    print("The 10,001st prime is = " + primeNum10001)
    println(" with a time of " + primeNum10001Time + " seconds\n")

    val stopwatch008 = new Stopwatch()
    val largestProductOutput = largestProduct(source)
    val largestProductTime = stopwatch008.elapsedTime()
    println("Problem #008")
    println("============")
    print("The largest consecutive product of 3 numbers is = " + largestProductOutput)
    println(" with a time of " + largestProductTime + " seconds\n")

    val stopwatch009a = new Stopwatch()
    val pythagoreanTripletOutput: Int = pythagoreanTripleP()
    val pythagoreanTripletTime = stopwatch009a.elapsedTime()
    println("Problem #009a")
    println("============")
    // the functional version runs about 30 seconds
    // the java version runs at about .4 seconds
    print("The procedural product of abc of the pythagoreanTripleP is = " + pythagoreanTripletOutput)
    println(" with a time of " + pythagoreanTripletTime + " seconds\n")

    val stopwatch009b = new Stopwatch()
    val pythagoreanTripleOutput: Int = pythagoreanTripleF()
    val pythagoreanTripleTime = stopwatch009b.elapsedTime()
    println("Problem #009b")
    println("============")
    // the functional version runs about 30 seconds
    // the java version runs at about .4 seconds
    print("The functional product of abc of the pythagoreanTripleF is = " + pythagoreanTripleOutput)
    println(" with a time of " + pythagoreanTripleTime + " seconds\n")

    val stopwatch010 = new Stopwatch()
    val twoMillion = 2000000
    val sumPrimesToTwoMillionOutput = (0L /: primesTo(twoMillion))(_ + _)
    val sumPrimesToTwoMillionTime = stopwatch010.elapsedTime()
    println("Problem #010")
    println("============")
    print("The procedural sum of primes to 2 million = " + sumPrimesToTwoMillionOutput)
    println(" with a time of " + sumPrimesToTwoMillionTime + " seconds\n")

    val stopwatch011 = new Stopwatch()
    val maxProductOutput = maxAll()
    val maxProductTime = stopwatch011.elapsedTime()
    println("Problem #011")
    println("============")
    print("The largest product of the grid = " + maxProductOutput)
    println(" with a time of " + maxProductTime + " seconds\n")

    val stopwatch012 = new Stopwatch()
    val mostDivisibleTriangleOutput = getNaturalNumbersWith(500)
    val mostDivisibleTriangleTime = stopwatch012.elapsedTime()
    println("Problem #012")
    println("============")
    print("The first triangle number with over 500 divisors = " + mostDivisibleTriangleOutput)
    println(" with a time of " + mostDivisibleTriangleTime + " seconds\n")

    val stopwatch013 = new Stopwatch()
    val firstTenDigitsOutput = firstTenDigits
    val firstTenDigitsTime = stopwatch013.elapsedTime()
    println("Problem #013")
    println("============")
    print("The first ten digits of the large sum = " + firstTenDigitsOutput)
    println(" with a time of " + firstTenDigitsTime + " seconds\n")

    val stopwatch014 = new Stopwatch()
    val collatzOutput = collatz(1000000)
    val collatzTime = stopwatch014.elapsedTime()
    println("Problem #014")
    println("============")
    print("The longest collatz sequence comes from a value of " + collatzOutput)
    println(" with a time of " + collatzTime + " seconds\n")

    val stopwatch015 = new Stopwatch()
    val size = 20
    val latticeOutput = lattice(size)
    val latticeTime = stopwatch015.elapsedTime()
    println("Problem #015")
    println("============")
    print("The number of paths for a lattice of " + size + "x" + size + " = " + latticeOutput)
    println(" with a time of " + latticeTime + " seconds\n")

    val stopwatch016 = new Stopwatch()
    val exponent = 1000
    val powerDigitSumOutput = sumOfDigits(exponent)
    val powerDigitSumTime = stopwatch016.elapsedTime()
    println("Problem #016")
    println("============")
    print("The sum of the digits of 2**1000 = " + powerDigitSumOutput)
    println(" with a time of " + powerDigitSumTime + " seconds\n")

    val stopwatch017 = new Stopwatch()
    val ceiling = 1000
    val letterCountsOutput = spelledOutLengthTo(ceiling)
    val letterCountsTime = stopwatch017.elapsedTime()
    println("Problem #017")
    println("============")
    print("The number-letter counts for integers 1 to " + ceiling + " = " + letterCountsOutput)
    println(" with a time of " + letterCountsTime + " seconds\n")

  }
}
