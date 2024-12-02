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
                return i + 1
            }
        }

        return -1
    }

    fun isPrefixOfWordSolution2(sentence: String, searchWord: String): Int {
        // List to store the words from the sentence
        val wordsList = mutableListOf<String>()

        // StringBuilder to build the current word
        val currentWord = StringBuilder()

        // Iterate through each character in the sentence
        for (char in sentence) {
            if (char != ' ') {
                // Append the character to the current word
                currentWord.append(char)
            } else {
                // If we encounter a space, add the current word to the list
                if (currentWord.isNotEmpty()) {
                    wordsList.add(currentWord.toString())
                    currentWord.clear()
                }
            }
        }

        // Add the last word if the sentence doesn't end with space
        if (currentWord.isNotEmpty())
            wordsList.add(currentWord.toString())

        // Iterate through the list of words to find the prefix match
        for (wordIndex in wordsList.indices) {
            val word = wordsList[wordIndex]
            if (word.length >= searchWord.length) {
                var isMatch = true
                for (charIndex in searchWord.indices) {
                    if (word[charIndex] != searchWord[charIndex]) {
                        isMatch = false
                        break
                    }
                }
                if(isMatch)
                    return wordIndex+1
            }
        }
        return -1
    }
}