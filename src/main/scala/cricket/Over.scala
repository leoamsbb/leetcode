package cricket

case class Over(balls: List[Ball])

object Over {
  implicit def fromAny(args: List[Any]): Over = Over(args.map(Ball.fromInput))
}