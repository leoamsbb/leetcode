
// https://leetcode.com/problems/reorder-data-in-log-files/
object ReorderDataInLogFiles_937 {

  def reorderLogFiles(logs: Array[String]): Array[String] = {

    val (let, dig) = logs.foldLeft((Array.empty[String], Array.empty[String])) {
      case ((letAcc, digAcc), elem) => elem match {
        case s"$_ $rest" if rest(0).isDigit => (letAcc, digAcc :+ elem)
        case _ => (letAcc :+ elem, digAcc)
      }
    }

    val stringComparator = (s1:String, s2:String) => {
      val (id1, contents1) = s1.splitAt(s1.indexOf(" "))
      val (id2, contents2) = s2.splitAt(s2.indexOf(" "))

      if (contents1 == contents2)
          id1 < id2
      else
          contents1 < contents2
    }
    let.sortWith(stringComparator) ++ dig
  }

  def main(args: Array[String]): Unit = {
    println(reorderLogFiles(Array("dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero")).mkString(","))
    println(reorderLogFiles(Array("dig1 8 1 5 1","let2 art can","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero")).mkString(","))
    println(reorderLogFiles(Array("a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo")).mkString(","))
  }
}
