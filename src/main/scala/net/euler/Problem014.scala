package net.euler

/**
 * Longest Collatz sequence
 *
 * The following iterative sequence is defined for the set of positive integers:
 *
 *   n → n/2 (n is even)
 *   n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 *
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * Which starting number, under one million, produces the longest chain?

 * User: Alexandros Bantis
 * Date: 3/8/13
 * Time: 4:54 PM
 */
object Problem014 {

  def collatzLen(n: Int): Int = {
    def iter(x: Long, len: Int): Int = {
      if (x == 1) len
      else if (x % 2 == 0) iter(x/2, len+1)
      else iter(3 * x + 1, len+1)
    }
    iter(n, 1)
  }

  lazy val odds: Stream[Int] = Stream.from(1,2)

  def collatz(ceiling: Int) =
    odds.takeWhile(_ < ceiling).map(x => (x, collatzLen(x))).reduce((x,y) => if (x._2 < y._2) y else x)._1

}
