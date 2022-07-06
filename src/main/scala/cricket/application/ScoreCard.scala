package cricket.application

import cricket.Player
import cricket.event.WicketDownEvent

case class ScoreCard(players: List[Player] = Nil, overs: BigDecimal = 0.0, batsman: (String, String) = ("", "")) {
  override def toString: String =
    s"""
       |Player Name Score 4s 6s Balls
       |${players.mkString("\n")}
       |
       |Total: $calculateTotalScore/$numOfWicketsDown
       |
       |Overs: $overs
       |""".stripMargin

  private def calculateTotalScore = players
    .map(_.scoreWithExtras)
    .sum

  private def numOfWicketsDown = players
    .flatMap(_.battingRecord)
    .count(_ == WicketDownEvent)
}
