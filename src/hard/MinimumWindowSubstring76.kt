package hard

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.

 */
/**
Leetcode link

https://leetcode.com/problems/minimum-window-substring/

 */
fun minWindow(s: String, t: String): String {
    if(s.isEmpty() || t.isEmpty()) return  ""

    val dictT = HashMap<Char,Int>()
    t.forEach { char->
        val count =dictT[char]?:0
        dictT[char]= count +1
    }
    val required = dictT.size

    // left and right pointer
    var left = 0
    var right = 0

    val length = s.length

    // formed is used to keep track how many unique characters in t
    // are presented in the current window in its desired frequency
    // e.g if t  is "AABC" then the window must have two A's , one B's , one C's .
    // thus formed would be =3 when all these conditions are met.
    var formed = 0

    // dictionary which keeps a count of all unique characters in the current window .
    val windowCount = HashMap<Char,Int>()

    val ans = intArrayOf(-1,0,0)

    while (right<s.length)
    {
        // add one character from the right to the window
        var char = s[right]
        val  count = windowCount[char]?:0
        windowCount[char]= count+1

        // if the frequency of the current character added equals to the
        // desired count in t then increment the formed count by 1.
        if(dictT.containsKey(char) && windowCount[char] == dictT[char])
            formed++

        while(left <= right && required==formed)
        {
            char = s[left]
            if(ans[0]==-1 || right -  left+1 <ans[0])
            {
                ans[0] = right-left+1
                ans[1]= left
                ans[2] = right
            }
            var count = windowCount[char]?:0
            windowCount[char]= count-1
            if(dictT.containsKey(char) && windowCount[char]?:0 < dictT[char]?:0)
                formed--
            left++
        }
        right++
    }
    return if(ans[0]==-1)
        ""
    else
        s.substring(ans[1],ans[2]+1)
}
