package net.euler

/**
 * Pandigital multiples
 *
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 *
 *     192 × 1 = 192
 *     192 × 2 = 384
 *     192 × 3 = 576
 *
 * By concatenating each product we get the 1 to 9 pandigital, 192,384,576.
 * We will call 192384576 the concatenated product of 192 and (1,2,3).
 *
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5,
 * giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
 *
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the
 * concatenated product of an integer with (1,2, ... , n) where n > 1?
 *
 * User: Alexandros Bantis
 * Date: 6/5/13
 * Time: 8:27 PM
 */
object Problem038 {

  def greatestPandigital(ceiling: Int): Long = {
    val multiples =
      for {
        i <- (1 to ceiling).toList
        n <- (2 to 9)
        avgDigits = ((n *  i.toString.length) + (n * (i.toString.length+1)) ) / 2
        if (avgDigits > 6 && avgDigits < 12)
        x = multiply(i, n)
        if (isPandigital(x))
      } yield x
    multiples.flatten.max
  }

  def multiply(number: Int, n: Int): Option[Long] = {
    val x: List[String] =
      for {
        i <- (1 to n).toList
        part = (number * i).toString
      } yield part
    if (x.flatten.size == 9)
      Some(("" /: x)(_ + _).toLong)
    else
      None
  }

  def isPandigital(n: Option[Long]): Boolean = {
    def iter(rem: List[Int], i: Int): Boolean = {
      if (rem.isEmpty) true
      else if (rem.head != i) false
      else iter(rem.tail, i+1)
    }
    n match {
      case None    => false
      case Some(x) => iter(x.toString.toList.sorted.map(y => y.toString.toInt), 1)
    }
  }
}