package medium

import java.lang.StringBuilder

/**
 * Given a list of words, each word consists of English lowercase letters.

Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2. For example, "abc" is a predecessor of "abac".

A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.

Return the longest possible length of a word chain with words chosen from the given list of words.
Example 1:

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chain is "a","ba","bda","bdca".
Example 2:

Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
Output: 5


Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 16
words[i] only consists of English lowercase letters.
 */

fun longestStrChain(words: Array<String>): Int {
    words.sortWith(Comparator { s1:String, s2:String -> s1.length - s2.length })
    val memo = HashMap<String,Int>()
    var result = 0
     for(i in words.indices)
    {
        memo[words[i]] = 1
        for(j in words[i].indices) {
            val builder = StringBuilder(words[i])
           val current= builder.deleteCharAt(j).toString()
            if(memo[current]!=null)
            {
                val temp = memo[current]!!
                memo[words[i]] =Math.max(memo[words[i]]?:0,temp+1)
            }
        }
        result =Math.max(result,memo[words[i]]!!)

    }

    return result
}