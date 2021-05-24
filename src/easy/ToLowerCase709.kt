package easy

import java.lang.StringBuilder

/**
 * Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
Example 1:

Input: s = "Hello"
Output: "hello"
Example 2:

Input: s = "here"
Output: "here"
Example 3:

Input: s = "LOVELY"
Output: "lovely"

Constraints:

1 <= s.length <= 100
s consists of printable ASCII characters.
 */

fun toLowerCase(s: String): String {
    val builder =StringBuilder()
    s.forEach { char->
        if(char in 'A'..'Z')
            builder.append(char.plus(32))
        else
            builder.append(char)
    }
return builder.toString()
}