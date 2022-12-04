
import scala.io.Source

object Main {

  def main(args: Array[String]): Unit = {

    val inputFileName = "input"
    //    val inputFileName = "example"

    val src = Source.fromFile(inputFileName + ".txt")

    val fileStrings = src.getLines


    while(fileStrings.hasNext) {
      val s = fileStrings.next()
    }


    src.close()



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
}
