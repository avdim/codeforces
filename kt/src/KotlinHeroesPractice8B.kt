fun main() {
  val a1 = readInt()
  val a2 = readInt()
  val k1 = readInt()
  val k2 = readInt()
  val n = readInt()

  val maxCardsWithoutRemoves = a1 * (k1 - 1) + a2 * (k2 - 1)
  val minRemovedPlayers = Math.max(0, n - maxCardsWithoutRemoves)
  println(minRemovedPlayers)

  class Team(val size: Int, val costToRemove: Int)

  var maxRemovedPlayers = 0
  var cardsLeft = n
  listOf(Team(a1, k1), Team(a2, k2)).sortedBy { it.costToRemove }.forEach {
    val removedFromCurrentTeam: Int = (cardsLeft / it.costToRemove).coerceAtMost(it.size)
    maxRemovedPlayers += removedFromCurrentTeam
    cardsLeft -= removedFromCurrentTeam * it.costToRemove
  }
  println(maxRemovedPlayers)
}


private fun readInt() = readLine()!!.toInt()
private fun readInts() = readLine()!!.split(" ").map { it.toInt() }

