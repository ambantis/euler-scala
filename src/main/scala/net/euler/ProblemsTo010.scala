package net.euler

object ProblemsTo010 {

  // Problem #1
  def getSumOfMultiplesTo(x: Int, y: Int, limit: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == limit) acc
      else if (n % x == 0 || n % y == 0) loop(acc + n, n + 1)
      else loop(acc, n + 1)
    loop(0, 0)
  }
}