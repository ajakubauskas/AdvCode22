
import scala.io.Source

object Main {

  def main(args: Array[String]): Unit = {

    val inputFileName = "input"
//            val inputFileName = "example"

    val src = Source.fromFile(inputFileName + ".txt")

    val fileStrings = src.getLines

    var sum = 0

    while(fileStrings.hasNext) {
      val s = fileStrings.next()
      if (s.nonEmpty) {
        val (compA, compB) = s.splitAt(s.length/2)

        val common = compA.toSet.intersect(compB.toSet)

//        println(common)

        val localSum = common.map(score).sum

//        println(localSum)

        sum += localSum
      }

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
