package medium

object MaxSumOfPairWithEqualSumOfDigits2342 {
    fun maximumSum(nums: IntArray): Int {
        val digitSumPairs = Array(nums.size) { Pair(0, 0) }

        // Store numbers with their digits sums as pairs
        for (i in nums.indices) {
            val digitSum = calculateDigitSum(nums[i])
            digitSumPairs[i] = Pair(digitSum, nums[i])
        }

        // Sort based on digit sums, and if equal, by number value
        val sortedDigitSumPairs =digitSumPairs.sortedWith(compareBy({ it.first }, { it.second }))

        var maxPairSum = -1

        // Iterate through the sorted array to find the maximum sum of pairs
        for (i in 1 until sortedDigitSumPairs.size) {
            val currentDigitSum = sortedDigitSumPairs[i].first
            val previousDigitSum = sortedDigitSumPairs[i - 1].first

            // If two consecutive number have the same digit sum
            if (currentDigitSum == previousDigitSum) {
                val currentSum = sortedDigitSumPairs[i].second + sortedDigitSumPairs[i - 1].second
                maxPairSum = Math.max(maxPairSum, currentSum)
            }
        }
        return maxPairSum
    }

    // Helper function to compute the sum of digits of a number
    private fun calculateDigitSum(num: Int): Int {
        var digitSum = 0
        var tempNum = num
        while (tempNum != 0) {
            digitSum += tempNum % 10
            tempNum /= 10
        }
        return digitSum
    }
}