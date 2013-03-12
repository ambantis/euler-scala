package net.euler

import scala.io.Source

/**
 * Maximum path sum
 *
 * By starting at the top of the triangle below and moving to adjacent numbers
 * on the row below, the maximum total from top to bottom is 23.
 *
 *                                           3
 *                                          7 4
 *                                         2 4 6
 *                                        8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23.
 *
 * Find the Find the maximum total from top to bottom in triangle.txt,
 * a 15K text file containing a triangle with one-hundred rows.
 *
 * User: Alexandros Bantis
 * Date: 3/11/13
 * Time: 8:11 PM
 */
object Huffman {
  abstract class CodeTree
  case class Fork(left: CodeTree, right: CodeTree, amt: Int, weight: Int) extends CodeTree
  case class Leaf(weight: Int) extends CodeTree

  def weight(t: CodeTree): Int = t match {
    case Fork(_,_,_, w) => w
    case Leaf(w)        => w
  }

  def max(t: CodeTree): Int = t match {
    case Fork(left, right, a, w) if (weight(left) >= weight(right)) => a + max(left)
    case Fork(left, right, a, w) if (weight(left) <  weight(right)) => a + max(right)
    case Leaf(a) => a
  }

  def makeCodeTree(l: CodeTree, r: CodeTree, amt: Int) =
    Fork(l, r, amt, Math.max(weight(l), weight(r)) + amt)

  val source =
    Source.fromURL(this.getClass.getResource("/triangle.txt")).
      getLines().toList.reverse.map(l => l.split(" ").map(n => n.toInt).toList)

  val huffmanTree: CodeTree = {
    def iter(tree: List[CodeTree], rem: List[List[Int]]): CodeTree = {
      if (rem.isEmpty) tree.head
      else iter(zipTree(tree, rem.head), rem.tail)
    }
    iter(source.head.map(n => Leaf(n)), source.tail)
  }

  def zipTree(base: List[CodeTree], top: List[Int]): List[CodeTree] = {
    def iter(trees: List[CodeTree], remRow: List[Int], remBase: List[CodeTree]): List[CodeTree] = {
      if (remRow.isEmpty) trees.reverse
      else iter(makeCodeTree(remBase.head, remBase.tail.head, remRow.head) :: trees, remRow.tail, remBase.tail)
    }
    iter(Nil, top, base)
  }


}
