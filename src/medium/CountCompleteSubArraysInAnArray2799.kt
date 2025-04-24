package medium

object CountCompleteSubArraysInAnArray2799 {
    fun countCompleteSubarrays(nums: IntArray): Int {
        val n = nums.size
        val k = nums.distinct().size
        var result = 0
        var start = 0
        var end = 0

        while (start < n) {
            while (end < n) {
                val subArray = nums.copyOfRange(start, end + 1)
                val subArrDistinct = subArray.distinct().size
                if (subArrDistinct == k)
                    result++
                end++
            }
            start++
            end = start
        }

        return result

    }
}