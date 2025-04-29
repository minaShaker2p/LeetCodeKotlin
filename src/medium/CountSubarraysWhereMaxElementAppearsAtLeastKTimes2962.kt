package medium

object CountSubarraysWhereMaxElementAppearsAtLeastKTimes2962 {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        val maximumNum = nums.max()
        val n = nums.size
        var left = 0
        var right = 0
        var subArrayCount = 0L

        while (left < n) {
            while (right < n) {
                val subArraySize = (right - left) + 1
                if (subArraySize < k) {
                    right++
                    continue
                }

                val subArray = nums.copyOfRange(left, right + 1)

                if (subArray.IsArrayMaxElementAppearAtLeastKTimes(maximumNum, k))
                    subArrayCount++
                right++
            }
            left++
            right = left
        }
        return subArrayCount
    }

    fun IntArray.IsArrayMaxElementAppearAtLeastKTimes(max: Int, k: Int): Boolean {
        return this.count { it == max } >= k
    }
}