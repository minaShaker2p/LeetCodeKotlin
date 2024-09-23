package medium

object ExtraCharactersInString2707 {
    fun minExtraChar(s: String, dictionary: Array<String>): Int {
        // To achieve O(1) lookups, convert the list of string in the dictionary to a set
        val dictionarySet = dictionary.toSet()
        val memo = IntArray(s.length) { -1 }
        return dp(0, s, dictionarySet, memo)

    }

    fun dp(startingIndex: Int, s: String, dictionary: Set<String>, memo:IntArray): Int {
        if (startingIndex == s.length) return 0

        if (memo[startingIndex] != -1)
            return memo[startingIndex]

        // To count this character as a left over character
        // move to index 'start+1'
        var ans = dp(startingIndex + 1, s, dictionary, memo) + 1
        for (i in startingIndex until s.length) {
            val subString = s.substring(startingIndex, i + 1)
            if (dictionary.contains(subString)) {
                ans = ans.coerceAtMost(dp(i + 1, s, dictionary, memo))
            }
        }
        memo[startingIndex] = ans
        return memo[startingIndex]
    }
}