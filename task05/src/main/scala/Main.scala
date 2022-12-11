
import scala.io.Source

object Main {

  def main(args: Array[String]): Unit = {

    val inputFileName = "input"
//            val inputFileName = "example"

    val src = Source.fromFile(inputFileName + ".txt")

    val fileStrings = src.getLines


    val initState = fileStrings.takeWhile(_.nonEmpty).toArray
    val maxStr = initState.maxBy(_.length).length

    val state = State.fromStrs(initState.map(_.padTo(maxStr, ' ')).map(_.toArray).transpose)

    while(fileStrings.hasNext) {

      val line = fileStrings.next()

      if (line.nonEmpty) {
        state.move(CraneMove.fromStr(line))
      }

    }

    src.close()

    println(state.top)


  }

}

case class CraneMove(size: Int, from: Int, to: Int)
object CraneMove {
  def fromStr(str: String) = str match {
    case s"move $size from $from to $to" => CraneMove(size.toInt, from.toInt - 1, to.toInt - 1)
  }
}

case class State(private val crates: Array[Array[Char]]) {
  def move(m: CraneMove) = {
    crates(m.to) = crates(m.from).take(m.size) ++ crates(m.to)
    crates(m.from) = crates(m.from).drop(m.size)
  }
  def top: String = {
    crates.map(_.headOption.getOrElse(' ')).mkString
  }
}
object State {
  def fromStrs(strs: Array[Array[Char]]): State = {
    val cleanStrs = strs.filter(_.exists(_.isDigit)).map(_.filter(_ != ' ').dropRight(1))

    State(cleanStrs)
  }
}


