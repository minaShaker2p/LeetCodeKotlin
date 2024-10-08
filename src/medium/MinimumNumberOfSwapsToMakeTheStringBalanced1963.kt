package medium

import java.util.Stack

object MinimumNumberOfSwapsToMakeTheStringBalanced1963 {
    fun minSwaps(s: String): Int {
        // Initialize stack to keep track of unmatched opening brackets [
        val stack =  Stack<Char>()
        // Initialize integer unbalanced to count unbalanced closing brackets ]
        var unbalanced = 0

        s.forEach { char ->
            // If an opening bracket is encountered, push it in the stack
            if(char == '[')
                stack.push(char)
            else
            {
                // If the stack is not empty, pop it.
                if(stack.isNotEmpty())
                    stack.pop()
                //Otherwise increase the count of unbalanced brackets.
                else
                    unbalanced++
            }
        }
        return (unbalanced+1)/2

    }
}