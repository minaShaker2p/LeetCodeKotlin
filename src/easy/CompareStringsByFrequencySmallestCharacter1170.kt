package easy

/**
 * Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.

Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.

Example 1:

Input: queries = ["cbd"], words = ["zaaaz"]
Output: [1]
Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
Example 2:

Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
Output: [1,2]
Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 */
/**
 * this solution take O(N) and O(1)
 */
fun numSmallerByFrequency(queries: Array<String>, words: Array<String>): IntArray {
    val results = mutableListOf<Int>()
    queries.forEach { query ->
        var freq = 0
        for (element in words) {
            if (query.getFrequency() < element.getFrequency()) {
                freq++
            }
        }
        results.add(freq)
    }
    return results.toIntArray()
}

fun String.getFrequency(): Int {
    var frequency = 0
    var smallest = this[0]
    this.forEach {
        if (it < smallest) {
            smallest = it
            frequency = 0
        }
        if (smallest == it)
            frequency++
    }
    return frequency
}