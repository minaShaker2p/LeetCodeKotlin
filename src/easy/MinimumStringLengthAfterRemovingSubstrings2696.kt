package easy

import java.util.Stack

object MinimumStringLengthAfterRemovingSubstrings2696 {
    fun minLength(s: String): Int {
        val characterStack = Stack<Char>()

        s.forEach { char ->
            if (char == 'B' && characterStack.isNotEmpty() && characterStack.peek() == 'A') {
                characterStack.pop()

            } else if (char == 'D' && characterStack.isNotEmpty() && characterStack.peek() == 'C') {
                characterStack.pop()
            } else
                characterStack.push(char)
        }

        return characterStack.size
    }
}