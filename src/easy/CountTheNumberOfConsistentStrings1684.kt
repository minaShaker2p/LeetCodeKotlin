package easy

object CountTheNumberOfConsistentStrings1684 {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        val allowedSet = allowed.toHashSet()
        var countOfConsistentStrings = 0

        for (word in words) {
            var valid = true
            for (char in word) {
                if (!allowedSet.contains(char))
                    valid = false
            }
            if (valid) countOfConsistentStrings++
        }
        return countOfConsistentStrings
    }
}