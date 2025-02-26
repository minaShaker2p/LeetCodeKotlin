package medium

import kotlin.math.abs

object MaximumAbsoluteSumOfAnySubarray1749 {

    fun maxAbsoluteSum(nums: IntArray): Int {
        val n = nums.size

        var maxAbsSum = Int.MIN_VALUE

        for (i in nums.indices) {
            var counter = 0
            for (j in i..<n) {
                counter += nums[j]
                maxAbsSum = maxAbsSum.coerceAtLeast(abs(counter))

            }
        }
        return maxAbsSum

    }
}