package medium

import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap

/**
 * Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.



Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.


Constraints:

1 <= words.length <= 500
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]
 */
fun topKFrequent(words: Array<String>, k: Int): List<String> {

    // calculate the frequency of the words array :O(N)
    val freq = HashMap<String, Int>()
    words.forEach { word ->
        freq[word] = freq.getOrDefault(word, 0) + 1
    }

    val wordComparator = Comparator<WordFrequency> { a, b ->
        if (a.freq != b.freq)
            b.freq - a.freq
        else
            a.word.compareTo(b.word)

    }

    val priorityQueue = PriorityQueue<WordFrequency>(wordComparator)

    for ((key, value) in freq) {
        priorityQueue.add(WordFrequency(key, value))
    }
    val result = mutableListOf<String>()
    for (i in 0 until k) {
        result.add(priorityQueue.remove().word)
    }
    return result
}

data class WordFrequency(val word: String, val freq: Int)