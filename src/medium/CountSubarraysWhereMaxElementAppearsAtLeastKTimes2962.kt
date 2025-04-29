package medium

object CountSubarraysWhereMaxElementAppearsAtLeastKTimes2962 {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        val maxElement = nums.max()
        var maxElementsInWindow = 0
        var start = 0
        var result = 0L

        for (element in nums) {
            if (element == maxElement) {
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
}