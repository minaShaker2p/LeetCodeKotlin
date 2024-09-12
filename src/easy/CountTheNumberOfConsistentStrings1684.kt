package easy

object CountTheNumberOfConsistentStrings1684 {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        val allowedSet = allowed.toHashSet()
        var countOfConsistentStrings = 0

        for (word in words) {
            var isCharacterAllowed = true
            for (char in word) {
                if (!allowedSet.contains(char))
                    isCharacterAllowed = false
            }
            if (isCharacterAllowed) countOfConsistentStrings++
        }
        return countOfConsistentStrings
    }
}