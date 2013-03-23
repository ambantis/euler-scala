package net.euler

import io.Source
import scala.util.Sorting.quickSort

/**
 * Names scores
 *
 * Using names.txt, a 46K text file containing over five-thousand first names,
 * begin by sorting it into alphabetical order. Then working out the alphabetical
 * value for each name, multiply this value by its alphabetical position in
 * the list to obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN,
 * which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
 * So, COLIN would obtain a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 * 
 * User: Alexandros Bantis
 * Date: 3/21/13
 * Time: 6:31 PM
 */
object Problem022 {
  def namesScores(file: String): Int = {
    def calcName(word: String): Int = (0 /: word.map(ch => ch - 'A' + 1))(_ + _)
    def trim(s: String): String = s.substring(1, s.length-1)
    val words = Source.fromURL(getClass.getResource("/" + file)).bufferedReader().readLine().split(",").map(w => trim(w))
    quickSort(words)
    val scores =
      for {
        wordTuple <- (1 to words.length).zip(words)
        score = wordTuple._1 * calcName(wordTuple._2)
      } yield score
    scores.sum
  }
}
