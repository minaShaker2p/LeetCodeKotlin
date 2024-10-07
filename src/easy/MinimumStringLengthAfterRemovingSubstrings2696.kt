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

    /**
     * String Replace
     */
    fun minLengthSolution2(s: String): Int {
       var string = s

        // Continue processing while "AB" or "CD" substrings exist
        while (string.contains("AB") || string.contains("CD")) {
            if (string.contains("AB"))
            {
                // Remove the occurrences of "AB"
                string = string.replace("AB","")
            }else if(string.contains("CD"))
            {
                // Remove the occurrences of "CD"
                string = string.replace("CD","")
            }
        }
        return string.length
    }
}