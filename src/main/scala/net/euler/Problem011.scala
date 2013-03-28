package net.euler

import scala.io.Source

/**
 * Largest product in a grid
 *
 * In a 20x20 grid below, what is the greatest product of four adjacent numbers
 * in the same direction (up, down, left, right, or diagonally) in the 20x20 graph?
 *
 * User: Alexandros Bantis
 * Date: 3/5/13
 * Time: 12:44 PM
 */
object Problem011 {

  val matrix: Array[Array[Int]] = {
    Source.fromURL(getClass.getResource("/problem011.txt")).getLines().
      toArray.map(l => l.split(" ").map(c => Integer.parseInt(c)))
  }

  def maxAll(): Int = List(maxRow(), maxCol(), maxRightDiagonal(), maxLeftDiagonal()).max

  def maxRow(): Int = {
    val values: IndexedSeq[Int] = for {
      y <- 0 to matrix.length - 1
      x <- 0 to matrix.length - 4
    } yield matrix(y)(x) * matrix(y)(x+1) * matrix(y)(x+2) * matrix(y)(x+3)
    values.max
  }

  def maxCol(): Int = {
    val values: IndexedSeq[Int] = for {
      x <- 0 to matrix.length - 1
      y <- 0 to matrix.length - 4
    } yield matrix(y)(x) * matrix(y+1)(x) * matrix(y+2)(x) * matrix(y+3)(x)
    values.max
  }

  def maxRightDiagonal(): Int = {
    val values: IndexedSeq[Int] = for {
      y <- 3 to matrix.length - 1
      x <- 0 to matrix.length - 4
      product = matrix(y)(x) * matrix(y-1)(x+1) * matrix(y-2)(x+2) * matrix(y-3)(x+3)
    } yield product
    values.max
  }

  def maxLeftDiagonal(): Int = {
    val values: IndexedSeq[Int] = for {
      y <- 3 to matrix.length - 1
      x <- 3 to matrix.length - 1
      product = matrix(y)(x) * matrix(y-1)(x-1) * matrix(y-2)(x-5) * matrix(y-3)(x-3)
    } yield product
    values.max
  }

}
