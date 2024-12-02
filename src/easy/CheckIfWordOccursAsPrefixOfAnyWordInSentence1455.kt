package easy

/**
 * Given a sentence that consists of some words separated by a single space, and a searchWord, check if searchWord is a prefix of any word in sentence.
 *
 * Return the index of the word in sentence (1-indexed) where searchWord is a prefix of this word. If searchWord is a prefix of more than one word, return the index of the first word (minimum index). If there is no such word return -1.
 *
 * A prefix of a string s is any leading contiguous substring of s.
 *
 * Example 1:
 *
 * Input: sentence = "i love eating burger", searchWord = "burg"
 * Output: 4
 * Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.
 *
 */

object CheckIfWordOccursAsPrefixOfAnyWordInSentence1455 {
    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        val words = sentence.split(" ")

        for (i in words.indices) {
            if (words[i].startsWith(searchWord, ignoreCase = true)) {
                return i+1
            }
        }

        return -1
    }
}