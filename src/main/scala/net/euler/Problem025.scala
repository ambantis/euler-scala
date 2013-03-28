package net.euler

/**
  * 1000-digit Fibonacci number
  *
  * The Fibonacci sequence is defined by the recurrence relation:
  *
  * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
  *
  * Hence the first 12 terms will be:
  *
  *  F1 = 1
  *  F2 = 1
  *  F3 = 2
  *  F6 = 8
  *  F7 = 13
  *  F8 = 21
  *  F9 = 34
  *  F10 = 55
  *  F11 = 89
  *  F12 = 144
  *
  * The 12th term, F12, is the first term to contain three digits.
  *
  * What is the first term in the Fibonacci sequence to contain 1000 digits?
  *
  * User: Alexandros Bantis
  * Date: 3/28/13
  * Time: 5:37 AM
  */
object Problem025 {

  lazy val fibs: Stream[BigInt] = {
    def f(a: BigInt, b: BigInt): Stream[BigInt] = a #:: f(b, a + b)
    f(BigInt.int2bigInt(1), BigInt.int2bigInt(2))
  }

  def getFibIndexContainingDigits(digits: Int) =
    fibs.takeWhile(f => f.toString().length < digits+1).indexWhere(f => f.toString().length == digits) + 2
}
