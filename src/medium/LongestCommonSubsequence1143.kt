package medium

/**
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.


Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.

 **/
lateinit var dp :Array<IntArray>
fun longestCommonSubsequence(text1: String, text2: String): Int {
    dp = Array(text1.length){ IntArray(text2.length){-1} }

return helper(text1,text2,0 ,0)
}
fun helper(text1: String, text2: String, index1:Int ,index2:Int) :Int
{
    if(index1 == text1.length || index2 == text2.length)
       return 0
    if(dp[index1][index2] >= 0)
        return dp[index1][index2]

    if(text1[index1] == text2[index2])
         dp[index1][index2]=  1+ helper(text1,text2,index1+1,index2+1)
    else
        dp[index1][index2] = Math.max( helper(text1,text2,index1+1,index2), helper(text1,text2,index1,index2+1))

    return dp[index1][index2]
}