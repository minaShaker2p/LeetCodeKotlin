package easy

/**
 * Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.



Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"


Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
 */
fun reverseVowels(s: String): String {
    val reversedWord = CharArray(s.length)
    var start = 0
    var end = s.length-1
    while (start<=end)
    {
        if(s[start].isVowel())
        {
            while (!s[end].isVowel())
            {
                reversedWord[end]=s[end]
                end--
            }
            val startChar = s[start]
            val endChar = s[end]
            reversedWord[start]=endChar
            reversedWord[end]=startChar
            start++
            end--
        }else
        {
            reversedWord[start]=s[start]
            start++
        }
    }
    return reversedWord.joinToString("")
}
fun Char.isVowel()= charArrayOf('a', 'e', 'i', 'o',  'u').contains(this.toLowerCase())