
import scala.io.Source

object Main {

  def main(args: Array[String]): Unit = {

    val inputFileName = "input"
//        val inputFileName = "example"

    val src = Source.fromFile(inputFileName + ".txt")

    val fileStrings = src.getLines

    val totalScore = scala.collection.mutable.Buffer.empty[Int]

    while(fileStrings.hasNext) {
      val s = fileStrings.next()

      if (s.nonEmpty) {
        val Array(handA, handB) = s.split(" ").map(Hand.handMap)
        val roundScore = score(handA, handB)
        totalScore.prepend(roundScore)
      }

    }


    src.close()


    println(totalScore.sum)


  }


  private def score(a: Hand, b: Hand): Int = {
      {
        if (b.isWin(a)) 6
        else if (b.isDraw(a)) 3
        else 0
      } + Hand.handValue(b)
  }

}


sealed trait Hand {
  def isWin(other: Hand): Boolean = (this, other) match {
    case (Rock, Scissors) => true
    case (Paper, Rock) => true
    case (Scissors, Paper) => true
    case _ => false
  }
  def isDraw(other: Hand): Boolean = this == other
}

object Rock extends Hand
object Paper extends Hand
object Scissors extends Hand

object Hand {
  val handMap = Map(
    "A" -> Rock,
    "B" -> Paper,
    "C" -> Scissors,
    "X" -> Rock,
    "Y" -> Paper,
    "Z" -> Scissors
  )

  val handValue = Map(
    Rock -> 1,
    Paper -> 2,
    Scissors -> 3
  )
}
