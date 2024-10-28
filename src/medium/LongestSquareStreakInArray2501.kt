package medium

object LongestSquareStreakInArray2501 {
    fun longestSquareStreak(nums: IntArray): Int {
        // Create a unique set of numbers
        val uniqueNumbers = mutableSetOf<Int>()
        nums.forEach { uniqueNumbers.add(it) }

        var longestStreak = 0

        for (startNumber in nums) {
            var currentStreak = 0
            var current = startNumber

            while (uniqueNumbers.contains(current)) {
                currentStreak++

                if (current * current > 1e5) break

                current *= current
            }
            longestStreak = longestStreak.coerceAtLeast(currentStreak)
        }
        return if (longestStreak < 2) -1 else longestStreak
    }
}