package medium

import java.util.*

/**
 * Given a balanced parentheses string s, return the score of the string.

The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.


Example 1:

Input: s = "()"
Output: 1
Example 2:

Input: s = "(())"
Output: 2
Example 3:

Input: s = "()()"
Output: 2


Constraints:

2 <= s.length <= 50
s consists of only '(' and ')'.
s is a balanced parentheses string.
 */
fun scoreOfParentheses(s: String): Int {
    val stack = Stack<Int>()

    for (char in s) {
        if(char=='(')
            stack.push(0)
        else
        {
            var value=0
            while (stack.peek()!=0)
            {
                value+=stack.pop()
            }
            value=Math.max(2*value,1)
            stack.pop()
            stack.push(value)
        }
    }

    var count=0

    while (stack.isNotEmpty())
    {
        count+=stack.pop()
    }
    return count
}