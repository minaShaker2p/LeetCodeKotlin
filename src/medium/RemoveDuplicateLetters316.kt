package medium

import java.lang.StringBuilder
import java.util.*

/**
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.



Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"


Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.
 */
fun removeDuplicateLetters(s: String): String {
    val stack= Stack<Int>()
    val lastIndex=IntArray(26)
    val seen=BooleanArray(26)

    for(i in s.indices)
        lastIndex[s[i]-'a']=i

    for (i in s.indices)
    {
        val c= s[i]-'a'

        if(seen[c])continue
        while (stack.isNotEmpty()&&stack.peek()>c&&i<lastIndex[stack.peek()])
        {
            seen[stack.pop()]=false
        }
        stack.push(c)
        seen[c]=true
    }

    val result=StringBuilder()
    while (stack.isNotEmpty())
    {
        result.insert(0,('a'.plus(stack.pop())))
    }


return result.toString()
}