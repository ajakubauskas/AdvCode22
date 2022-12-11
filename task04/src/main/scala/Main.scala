
import scala.io.Source

object Main {

  def main(args: Array[String]): Unit = {

    val inputFileName = "input"
//            val inputFileName = "example"

    val src = Source.fromFile(inputFileName + ".txt")

    val fileStrings = src.getLines

    var count = 0

    while(fileStrings.hasNext) {

      val line = fileStrings.next()

      if (line.nonEmpty) {
        val Array(a, b) = line.split(",")
        val rangeA = Interval.fromString(a)
        val rangeB = Interval.fromString(b)

        if (rangeA.overlap(rangeB))
          count += 1

      }



    }


    src.close()

    println(count)


  }

}

case class Interval(from: Int, to: Int) {
  def contains(other: Interval): Boolean =
    from <= other.from && other.to <= to

  def overlap(other: Interval): Boolean = {
    from <= other.to && other.from <= to
  }

}
object Interval {
  def fromString(str: String) = {
    val Array(from, to) =  str.split("-")
    Interval(from.toInt, to.toInt)
  }
}

