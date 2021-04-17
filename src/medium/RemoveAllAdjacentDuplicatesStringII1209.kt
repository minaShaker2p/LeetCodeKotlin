package medium

import java.lang.StringBuilder
import java.util.*

/**
You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.



Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 */

data class Element(val ch :Char , var count :Int)
fun removeDuplicates(s: String, k: Int): String {

    val builder = StringBuilder()
    val stack = Stack<Element>()

    s.forEach {ch->
        if(stack.isNotEmpty())
        {
            val prev = stack.peek()
            if(ch == prev.ch)
            {
                stack.pop()
                stack.push(Element(ch,prev.count+1))
            }else
            {
                stack.push(Element(ch,1))
            }

        }else
        {
            stack.push(Element(ch,1))
        }

        if(stack.peek().count ==k)
            stack.pop()
    }

    while (stack.isNotEmpty())
    {
        repeat(stack.peek().count)
        {
            builder.append(stack.peek().ch)
        }
        stack.pop()
    }


    return builder.reverse().toString()
}