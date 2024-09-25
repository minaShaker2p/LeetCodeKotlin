package hard

object SumOfPrefixScoresOfStrings2416 {
    fun sumPrefixScores(words: Array<String>): IntArray {
        // Count the frequency of prefixes
        val map = HashMap<String, Int>()
        for (word in words) {
            for (i in word.indices) {
                val prefix = word.substring(0, i + 1)
                map[prefix] = map.getOrDefault(prefix, 0) + 1
            }
        }

        val answer = IntArray(words.size)

        for (i  in words.indices) {
            var count=0
            for (j in words[i].indices) {
                val prefix = words[i].substring(0, j + 1)
                count+= map.getOrDefault(prefix, 0)
            }
            answer[i] = count
        }

        return answer

    }
}