package net.euler

/**
 * Lattice Paths
 *
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner. How many such routes are there through a 20×20 grid?

 * User: Alexandros Bantis
 * Date: 3/9/13
 * Time: 7:48 PM
 */
object Problem015 {

  def pascalsTriangle(n: Int): List[Long] = {
    def row(lastRow: List[Long], thisRow: List[Long]): List[Long] = {
      if (lastRow.tail.isEmpty) 1L :: thisRow ++ (1L :: Nil)
      else row(lastRow.tail, lastRow.head + lastRow.tail.head :: thisRow)
    }
    def iter(i: Int, last: List[Long]): List[Long] = {
      if (i == n) last
      else iter(i+1, row(last, Nil))
    }
    iter(1, List(1, 1))
  }

  def lattice(row: Int): Long = (0L /: pascalsTriangle(row).map(x => x * x))(_ + _)
}
