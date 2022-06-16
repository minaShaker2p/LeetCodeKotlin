package medium

/**
 * Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */

fun longestPalindrome(s: String): String {
    var start=0
    var end=0
    for(i in s.indices)
    {
        val len=Math.max(expand(s,i,i), expand(s,i,i+1))
        if (len>end-start)
        {
            start= i-(len-1)/2
            end = i+len/2
        }
    }
    return s.substring(start,end+1)

}

fun expand(s:String,left:Int,right:Int):Int
{
    var l=left
    var r=right
    while (l>=0 && r<s.length&&s[l]==s[r])
    {
        l--
        r++
    }
    return r-l-1

}