
import scala.io.Source

object Main {

  def main(args: Array[String]): Unit = {

    val inputFileName = "input"
//            val inputFileName = "example"

    val src = Source.fromFile(inputFileName + ".txt")

    val fileStrings = src.getLines

    var marker = 0

    while(fileStrings.hasNext) {

      val line = fileStrings.next()

      if (line.nonEmpty) {


        marker = line.sliding(4).indexWhere(allCharsDifferent) + 4

      }

    }

    src.close()

    println(marker)


  }

  private def allCharsDifferent(s: String) = s.toSet.size == 4


}


