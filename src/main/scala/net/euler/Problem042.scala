package net.euler

import scala.io.Source

/**
 * Coded triangle numbers
 *
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1);
 * so the first ten triangle numbers are:
 *      1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * By converting each letter in a word to a number corresponding to its alphabetical position
 * and adding these values we form a word value. For example, the word value for
 * SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number
 * then we shall call the word a triangle word.
 *
 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing
 * nearly two-thousand common English words, how many are triangle words?
 *
 * User: Alexandros Bantis
 * Date: 6/7/13
 * Time: 10:23 PM
 */
object Problem042 {
  def trim(s: String): String = s.substring(1, s.length-1)
  val words: List[String] = Source.fromURL(getClass.getResource("/problem042.txt")).
    bufferedReader().readLine().split(",").map(w => trim(w.toLowerCase)).toList

  def triangleNumbers(ceiling: Int): List[Int] = {
    def iter(acc: List[Int], i: Int): List[Int] = {
      if (i > ceiling) acc
      else iter (i * (i+1) / 2 :: acc, i+1)
    }
    iter(Nil, 1)
  }

  def wordValue(word: String): Int = word.toList.map(c => c - 'a' + 1).sum

  def answer: Int = {
    val wordValues: List[Int] = words.map(w => wordValue(w))
    val tNumbers = triangleNumbers(wordValues.max)
    wordValues.count(x => tNumbers.contains(x))
  }

}
