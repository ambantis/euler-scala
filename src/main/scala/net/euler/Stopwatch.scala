package net.euler

/**
 * 
 * User: Alexandros Bantis
 * Date: 1/26/13
 * Time: 8:25 PM
 */
case class Stopwatch() {
  val start: Double = System.currentTimeMillis()
  def elapsedTime(): Double = (System.currentTimeMillis() - start) / 1000.0
}
