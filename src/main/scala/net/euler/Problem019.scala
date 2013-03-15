package net.euler

/**
 * Counting Sundays
 *
 * You are given the following information:
 *
 *   1 Jan 1900 was a Monday.
 *   Thirty days has September,
 *   April, June and November.
 *   All the rest have thirty-one,
 *   Saving February alone,
 *   Which has twenty-eight, rain or shine.
 *   And on leap years, twenty-nine.
 *
 *   A leap year occurs on any year evenly divisible by 4,
 *   but not on a century unless it is divisible by 400.
 *
 *   How many Sundays fell on the first of the month during the twentieth
 *   century (1 Jan 1901 to 31 Dec 2000)?
 *
 * User: Alexandros Bantis
 * Date: 3/13/13
 * Time: 8:10 PM
 */
object Problem019 {

  val leapYear = Array(0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
  val regYear =  Array(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
  def isLeap(year : Int): Boolean = year % 4 == 0 && year % 100 != 0 || year % 400 == 0
  def isLastDay(year: Int, month: Int, day: Int, leap: Boolean): Boolean =
    if (leap) day == leapYear(month) else day == regYear(month)

  def incDate(date: (Int, Int, Int, Boolean)): (Int, Int, Int, Boolean) = {
    date match {
      case (y, 12, 31, l)                            => (y+1, 1, 1, isLeap(y+1))
      case (y,  m,  d, l) if (isLastDay(y, m, d, l)) => (y, m+1, 1, l)
      case (y,  m,  d, l)                            => (y, m, d+1, l)
    }
  }

  def calcSundays(): Int = {
    def iter(i: Int, sundays: Int, date: (Int, Int, Int, Boolean)): Int = {
      if (date._1 == 2000 && date._2 == 12 && date._3 == 31) sundays
      else if (date._1 > 1900 && date._3 == 1 && i % 7 == 0) iter(i+1, sundays+1, incDate(date))
      else iter(i+1, sundays, incDate(date))
    }
    iter(1, 0, (1900, 1, 1, false))
  }
}
