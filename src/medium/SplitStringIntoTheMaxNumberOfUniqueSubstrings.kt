package medium

object SplitStringIntoTheMaxNumberOfUniqueSubstrings {
    fun maxUniqueSplit(s: String): Int {
        val seen = mutableSetOf<String>()
        return backtrack(s, 0, seen)

    }

    private fun backtrack(s: String, start: Int, seen: MutableSet<String>): Int {
        // Base case: If we reach the end of the string, return 0 (no more substrings to add)
        if (start == s.length)
            return 0

        var maxCount = 0

        // Try every possible substring starting from 'start'
        for (end in start + 1 until s.length) {
            val subString = s.substring(start, end)
            // If the substring is unique
            if (seen.contains(subString).not()) {
                // Add the substring to the seen set
                seen.add(subString)
                // Recursively count the unique substrings from the next position
                maxCount = Math.max(maxCount, 1 + backtrack(s, end, seen))
                // Backtrack: remove the substring from the seen set
                seen.remove(subString)
            }
        }
        return maxCount
    }
}