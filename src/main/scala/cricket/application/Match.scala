package cricket.application

import cricket.event._
import cricket.{Over, Player, Setup}

object Match {

  private val overIncrementer = BigDecimal("0.1")

  def playMatch(setup: Setup): List[ScoreCard] = {
    val startMatchTeam1 = startOfTheMatch(setup.battingOrderTeam1)
    val scTeam1 = prepareScoreCard(startMatchTeam1, setup.oversTeam1)

    val startMatchTeam2 = startOfTheMatch(setup.battingOrderTeam2)
    val scTeam2 = prepareScoreCard(startMatchTeam2, setup.oversTeam2)

    List(scTeam1, scTeam2)
  }

  private def prepareScoreCard(startMatch: ScoreCard, overs: List[Over]) = {
    overs
      .flatMap(over => over.balls.flatMap(MatchEvent.fromBall) ::: List(OverChangeEvent, StrikeChangeEvent))
      .dropRight(2)
      .foldLeft(startMatch) {
        (acc, event) =>
          event match {
            case StrikeChangeEvent =>
              val (striker, nonStriker) = acc.batsman
              acc.copy(batsman = (nonStriker, striker), overs = incrementBallInOver(acc.overs))

            case OverChangeEvent =>
              acc.copy(overs = acc.overs.rounded)

            case WicketDownEvent =>
              val nextBatsmanIndex = getNextBatsmanIndex(acc.players)
              val updatedStriker = strikerUpdated(acc.players, acc.batsman._1, event)
              if (nextBatsmanIndex == -1)
                acc.copy(players = updatedStriker, overs = incrementBallInOver(acc.overs))
              else {
                val nextBatsman = acc.players(nextBatsmanIndex).addEvent(BattingStartedEvent)
                val updatedNextBatsman = updatedStriker.updated(nextBatsmanIndex, nextBatsman)
                acc.copy(players = updatedNextBatsman, batsman = (nextBatsman.name, acc.batsman._2), overs = incrementBallInOver(acc.overs))
              }

            case _ =>
              val updatedPlayers = strikerUpdated(acc.players, acc.batsman._1, event)
              acc.copy(players = updatedPlayers, overs = incrementBallInOver(acc.overs))
          }
      }
  }

  private def incrementBallInOver(current: BigDecimal) = {
    current + overIncrementer
  }

  private def strikerUpdated(players: List[Player], striker: String, event: MatchEvent) = {
    val strikerPlayerIndex = players.indexWhere(_.name == striker)
    val strikerPlayer = players(strikerPlayerIndex)
    players.updated(strikerPlayerIndex, strikerPlayer.addEvent(event))
  }

  private def getNextBatsmanIndex(players: List[Player]) =
    players.indexWhere(!_.battingRecord.contains(BattingStartedEvent))

  private def startOfTheMatch(battingOrder: List[String]) = {
    val players = battingOrder.map(Player(_))
    val (first, second) = (players.head, players.tail.head)
    val startingBatting = players
      .updated(0, first.addEvent(BattingStartedEvent))
      .updated(1, second.addEvent(BattingStartedEvent))

    ScoreCard(players = startingBatting, batsman = (first.name, second.name))
  }
}
