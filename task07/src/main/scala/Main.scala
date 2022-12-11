
import scala.io.Source

object Main {

  def main(args: Array[String]): Unit = {

//    val inputFileName = "input"
            val inputFileName = "example"

    val src = Source.fromFile(inputFileName + ".txt")

    val fileStrings = src.getLines


    while(fileStrings.hasNext) {

      val line = fileStrings.next()

      if (line.nonEmpty) {



      }

    }

    src.close()



  }



}

sealed trait Entity
case class Dir(name: String, content: List[Entity]) extends Entity
case class File(name : String, size: Long)

sealed trait Command extends Entity
case object Ls extends Command
case object CdUp extends Command
case class CdDir(dir: String) extends Command

object Command {
  def fromStr(s: String) = s match {
    case "$ ls" => Ls
    case "$ cd .." => CdUp
    case s"$$ cd $dirName" => CdDir(dirName)
  }
}

object File {
  private def onlyDigits(s: String) = s.toArray.forall(_.isDigit)

  def fromStr(str: String) = str match {
    case s"$size $fname" if onlyDigits(size) => File(fname, size.toLong)
  }
}
