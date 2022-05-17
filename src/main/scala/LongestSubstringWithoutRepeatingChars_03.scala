
// 3. https://leetcode.com/problems/longest-substring-without-repeating-characters/
object LongestSubstringWithoutRepeatingChars_03 {

  def main(args: Array[String]): Unit = {
    assert(lengthOfLongestSubstring("abcabcbb") == 3)
    println("_______________________________________")

    assert(lengthOfLongestSubstring("bbbbb") == 1)
    println("_______________________________________")

    assert(lengthOfLongestSubstring("pwwkew") == 3)
    println("_______________________________________")

    assert(lengthOfLongestSubstring("aab") == 2)
    println("_______________________________________")

    assert(lengthOfLongestSubstring("dvdf") == 3)
    println("_______________________________________")

    assert(lengthOfLongestSubstring("") == 0)
    println("_______________________________________")

    assert(lengthOfLongestSubstring("ohvhjdml") == 6)
    println("_______________________________________")
  }

  private def lengthOfLongestSubstring(s: String): Int = {
    var currentSS = ""
    var maxSoFar = 0
    var maxEndingHere = 0

    s.foreach(ch => {
      if (currentSS.contains(ch)) {
        val index = currentSS.indexOf(ch)
        val proposed = currentSS.substring(index + 1).appended(ch)

        println(s"index: $index")
        println(s"proposed: $proposed")
        currentSS = proposed
        maxEndingHere = currentSS.length
      } else {
        currentSS = currentSS.appended(ch)
        if (maxSoFar <= currentSS.length) {
          maxSoFar = currentSS.length
        }
      }
      if (maxSoFar <= maxEndingHere) maxSoFar = maxEndingHere
      println(s"currentSS: $currentSS")
      println(s"maxSoFar: $maxSoFar")
    })

    maxSoFar
  }
}
