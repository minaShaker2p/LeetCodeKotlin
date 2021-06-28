package easy

import java.lang.StringBuilder
import java.util.*

/**
You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.


Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:

Input: s = "azxxzy"
Output: "ay"
 **/

fun removeDuplicates(s: String): String {
    val stack = Stack<Char>()
    for(i in s.indices) {
        if (stack.isNotEmpty()) {
            val peek = stack.peek()
            if (peek == s[i]) {
                stack.pop()
                continue
            }
        }
            stack.push(s[i])
        }


        val builder = StringBuilder()
        while (stack.isNotEmpty())
            builder.append(stack.pop())
    return builder.reversed().toString()

}