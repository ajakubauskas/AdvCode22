
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
