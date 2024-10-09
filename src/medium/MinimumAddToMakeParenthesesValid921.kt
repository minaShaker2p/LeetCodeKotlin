package medium

import java.util.Stack

object MinimumAddToMakeParenthesesValid921 {

    fun minAddToMakeValid(s: String): Int {
        val stack = Stack<Char>()
        s.forEach { char ->
            if (char == '(' || stack.isEmpty())
                stack.push(char)
            else {
                if (stack.isNotEmpty()) {
                    val peek = stack.peek()
                    if (peek == '(')
                        stack.pop()
                    else
                        stack.push(char)
                }
            }
        }
        return stack.size
    }
}