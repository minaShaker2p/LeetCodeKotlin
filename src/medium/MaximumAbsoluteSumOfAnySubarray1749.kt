package medium

import kotlin.math.abs

object MaximumAbsoluteSumOfAnySubarray1749 {

    fun maxAbsoluteSum(nums: IntArray): Int {
        var minPrefixSum = Int.MAX_VALUE
        var maxPrefixSum = Int.MIN_VALUE
        var prefixSum = 0
        var maxAbsSum = 0

        for (i in nums.indices) {
            // Prefix sum from index 0 to i
            prefixSum += nums[i]

            // Minimum & Maximum prefix sum we have seen so far
            minPrefixSum = minPrefixSum.coerceAtMost(prefixSum)
            maxPrefixSum = maxPrefixSum.coerceAtLeast(prefixSum)

            if (prefixSum > 0) {
                // If the prefixSum is positive, we will get the difference between prefixSum & minPrefixSum
                maxAbsSum = maxAbsSum.coerceAtLeast(prefixSum.coerceAtLeast(prefixSum - minPrefixSum))
            } else {
                // If the prefixSum is negative, we will get the absolute difference between prefixSum & maxPrefixSum
                maxAbsSum = maxAbsSum.coerceAtLeast(abs(prefixSum).coerceAtLeast(abs(prefixSum - maxPrefixSum)))
            }
        }
        return maxAbsSum
    }
}