package medium

/**
 * Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.
Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.
Example 2:

Input: words = ["a","b","c"], pattern = "a"
Output: ["a","b","c"]


Constraints:

1 <= pattern.length <= 20
1 <= words.length <= 50
words[i].length == pattern.length
pattern and words[i] are lowercase English letters.
 */
fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
    val map = HashMap<Char, Char>()
    val result = mutableListOf<String>()

    words.forEach {word->
        if(word.length == pattern.length) {
            map.clear()
            var canAdd= true
            for (i in word.indices)
            {
               val temp =map[pattern[i]]?:""
                if(temp=="")
                {
                    map[pattern[i]] = word[i]
                }else if(word[i]!=temp)
                    canAdd= false
            }
            if(canAdd)
                result.add(word)
        }
    }

return result
}
fun findAndReplacePatternSol2(words: Array<String>, pattern: String): List<String> {
    val result = mutableListOf<String>()
    words.forEach {word->
        if(word.isMatch(pattern) && word.length == pattern.length)
            result.add(word)
    }
    return result
}

private fun String.isMatch(pattern: String): Boolean {

    val patternToWord = CharArray(26)
    val wordToPattern = CharArray(26)
    patternToWord.fill('0')
    wordToPattern.fill('0')

    for(i in this.indices)
    {
        val patternChar = pattern[i]
        val wordChar = this[i]

        if(patternToWord[patternChar-'a']=='0')
            patternToWord[patternChar-'a']=wordChar
        if(wordToPattern[wordChar-'a'] =='0')
            wordToPattern[wordChar-'a'] = patternChar

        if(patternToWord[patternChar-'a'] != wordChar || wordToPattern[wordChar-'a'] != patternChar  )
            return false
    }

    return true
}
