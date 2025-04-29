package medium

object CountSubarraysWhereMaxElementAppearsAtLeastKTimes2962 {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        val maxElement = nums.max()
        var maxElementsInWindow = 0
        var start = 0
        var result = 0L

        for (end in 0 until nums.size) {
            if (nums[end] == maxElement) {
                maxElementsInWindow++
            }

            while (maxElementsInWindow == k) {
                if (nums[start] == maxElement)
                    maxElementsInWindow--
                start++
            }
            result += start
        }

        return result
    }

    fun IntArray.IsArrayMaxElementAppearAtLeastKTimes(max: Int, k: Int): Boolean {
        return this.count { it == max } >= k
    }
}