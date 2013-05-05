package net.euler

/**
 * Coin sums
 *
 * In England the currency is made up of pound, £, and pence, p,
 * and there are eight coins in general circulation:
 *           1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 *
 * It is possible to make £2 in the following way:
 *           1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 *
 * How many different ways can £2 be made using any number of coins?
 *
 * User: Alexandros Bantis
 * Date: 5/4/13
 * Time: 9:46 PM
 */
object Problem031 {

  def coinSums(money: Int, coins: List[Int]): Int =
    if (money == 0) 1
    else if (money < 0 || coins.isEmpty) 0
    else coinSums(money - coins.head, coins) + coinSums(money, coins.tail)
}
