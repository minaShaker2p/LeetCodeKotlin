package easy

/**
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true


Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character
 */

fun isIsomorphic(s: String, t: String): Boolean {
    val mapS = HashMap<Char, Char>()
    val mapT = HashMap<Char, Char>()

    for (i in s.indices) {
        val value = mapS[s[i]]
        if (value == null || value == t[i]) {
            mapS[s[i]] = t[i]
        } else
            return false
    }

    for (i in s.indices) {
        val value = mapT[t[i]]
        if (value == null || value == s[i]) {
            mapT[t[i]] = s[i]
        } else
            return false
    }

    return mapS.size == mapT.size
}