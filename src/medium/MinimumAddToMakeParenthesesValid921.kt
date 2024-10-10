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

    fun minAddToMakeValidSolution2(s: String): Int {
        // initialize openBrackets to track unmatched open brackets
        var openBrackets = 0
        var minAddRequired = 0

        s.forEach { char ->
            if (char == '(')
                openBrackets++
            else {
                // If an open bracket exists, match it with the closing one
                // If not, we need to add an open bracket
                if (openBrackets > 0) {
                    openBrackets--
                } else {
                    minAddRequired++
                }
            }
        }

        // Add the remaining open brackets as closing brackets would be required
        return minAddRequired + openBrackets
    }
}