
import scala.io.Source

object Main {

  def main(args: Array[String]): Unit = {

    val inputFileName = "input"
//    val inputFileName = "example"

    val src = Source.fromFile(inputFileName + ".txt")

    val fileStrings = src.getLines


    val buffer = scala.collection.mutable.Buffer.empty[Long]

    val sums = scala.collection.mutable.Buffer.empty[Long]


    while(fileStrings.hasNext) {
      val s = fileStrings.next()
      if (s.nonEmpty) {
        buffer.prepend(s.toLong)

      } else {
        val candidate = buffer.sum
        sums.prepend(candidate)

        buffer.clear()
      }
    }


    src.close()


    println(sums.sorted.takeRight(3).sum)

  }

}
