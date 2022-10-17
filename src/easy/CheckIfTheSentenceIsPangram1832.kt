package easy

/**
 * A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.



Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
Example 2:

Input: sentence = "leetcode"
Output: false


Constraints:

1 <= sentence.length <= 1000
sentence consists of lowercase English letters.
 */
fun checkIfPangram(sentence: String): Boolean {
    val seen = mutableSetOf<Char>()
    sentence.forEach { char->
        seen.add(char)
    }
    return seen.size ==26
}

fun checkIfPangramSol2(sentence: String): Boolean {

    for(i in 0 until 26)
    {
        val char :Char= 'a'+i
        if(sentence.indexOf(char)==-1)
            return false

    }
    return true
}