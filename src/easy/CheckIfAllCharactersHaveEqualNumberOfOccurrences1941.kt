package easy

object CheckIfAllCharactersHaveEqualNumberOfOccurrences1941 {
    fun areOccurrencesEqual(s: String): Boolean {
        val freqMap = HashMap<Char, Int>()

        s.forEach { char ->
            freqMap[char] = freqMap.getOrDefault(char, 0) + 1
        }

        val countBase = freqMap[s[0]]

        for ((k, v) in freqMap) {
            if (v != countBase)
                return false
        }

        return true
    }
}