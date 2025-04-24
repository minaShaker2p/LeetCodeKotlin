package medium

object CountCompleteSubArraysInAnArray2799 {
    fun countCompleteSubarrays(nums: IntArray): Int {
        val n = nums.size
        val distinct = nums.distinct().size
        var result = 0
        var left = 0
        var right = 0
        val distinctMap = HashMap<Int, Int>()

        while (left < n) {
            if (left > 0) {
                val key = nums[left - 1]
                distinctMap[key] = distinctMap.getOrDefault(key, 0) - 1
                if (distinctMap.getOrDefault(key, 0) == 0) {
                    distinctMap.remove(key)
                }
            }
            while (right < n && distinctMap.size < distinct) {
                val currentKey = nums[right]
                distinctMap[currentKey] = distinctMap.getOrDefault(currentKey, 0) + 1
                right++
            }
            if (distinctMap.size == distinct) {
                result += n - right + 1
            }
            left++
        }

        return result
    }
}