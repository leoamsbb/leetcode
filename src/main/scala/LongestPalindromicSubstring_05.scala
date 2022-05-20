import scala.util.control.Breaks.break

// https://leetcode.com/problems/longest-palindromic-substring/
object LongestPalindromicSubstring_05 {


  def longestPalindrome(s: String): String = {
    def left(index: Int): Char = s.charAt(index - 1)
    def right(index: Int): Char = s.charAt(index + 1)

    def findPalindrome(s: String) : String = {
      var longestPalindrome = ""
      var index = 1
      var palindrome = ""
      while(index < s.length-1) {
        val current = s.charAt(index)
        val l = left(index)
        val r = right(index)
        var dec = index
        var inc = index

        if (l == r && l == current) {
          palindrome = s"$l$current$r"
          dec = index - 1
          inc = index + 1
        } else if (l == current) {
          palindrome = s"$l$current"
          dec = index - 1
        } else if (r == current) {
          palindrome = s"$r$current"
          inc = index + 1
        } else {
          palindrome = current.toString
        }

        while (dec > 0 && inc < s.length-1) {
          val l = left(dec)
          val r = right(inc)

          if (l == r)
            palindrome = s"$l$palindrome$r"
          else
            dec = 0

          dec -= 1
          inc += 1
        }

        if (palindrome.length > longestPalindrome.length)
          longestPalindrome = palindrome

        index += 1
      }

      longestPalindrome
    }

    if (s.length == 1 || s.isEmpty)
      s
    else if (s == s.reverse)
      s
    else if(s.length == 2)
      s.charAt(0).toString
    else
      findPalindrome(s)
  }

  def main(args: Array[String]): Unit = {
    assert(longestPalindrome("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg") == "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff")
    println("------------------------------------------------------------")

    assert(longestPalindrome("abb") == "bb")
    println("------------------------------------------------------------")

    assert(longestPalindrome("babad") == "bab")
    println("------------------------------------------------------------")

    assert(longestPalindrome("cbbd") == "bb")
    println("------------------------------------------------------------")

    assert(longestPalindrome("a") == "a")
    println("------------------------------------------------------------")

    assert(longestPalindrome("") == "")
    println("------------------------------------------------------------")

    assert(longestPalindrome("cc") == "cc")
    println("------------------------------------------------------------")

    assert(longestPalindrome("ccc") == "ccc")
    println("------------------------------------------------------------")

  }
}
