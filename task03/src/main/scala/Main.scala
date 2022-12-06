
import scala.io.Source

object Main {

  def main(args: Array[String]): Unit = {

    val inputFileName = "input"
//            val inputFileName = "example"

    val src = Source.fromFile(inputFileName + ".txt")

    val fileStrings = src.getLines

    var sum = 0

    while(fileStrings.hasNext) {
      val List(a, b, c) = fileStrings.take(3).toList

      val ab = a.toSet intersect b.toSet
      val bc = b.toSet intersect c.toSet
      val common = ab intersect bc

      val localSum = common.map(score).sum


        sum += localSum

    }


    src.close()

    println(sum)


  }

  private val lowerCaseDiff = 'a'.toInt - 1
  private val upperCaseDiff = 'A'.toInt - 27


  private def score(c: Char): Int = if (c.isLower) {
    c.toInt - lowerCaseDiff
  } else {
    c.toInt - upperCaseDiff
  }
}
