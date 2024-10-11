package medium

object MaximumWidthRamp962 {
    // Approach 1: Brute Force (Time Limit Exceeded)
    fun maxWidthRamp(nums: IntArray): Int {
        var maxRamp = 0
        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                if (nums[i] <= nums[j])
                    maxRamp = maxRamp.coerceAtLeast(j - i)
            }
        }
        return maxRamp
    }

    // Approach 2: Sorting
    fun maxWidthRampSolution2(nums: IntArray): Int {
        val n = nums.size
        val indices = IntArray(n)

        // Initialize the array with indices
        for (i in 0 until n) {
            indices[i] = i
        }

        // Sort indices based on corresponding values in nums and ensure stability
       val sortedIndices= indices.sortedWith(Comparator<Int> { a, b ->
            if (nums[a] != nums[b])
                nums[a] - nums[b]
            else
                a - b
        })

        var minIndex = n // Minimum index encountered so far
        var maxWidth = 0

        // Calculate maximum width ramp
        for(i in sortedIndices)
        {
            maxWidth = maxWidth.coerceAtLeast(i - minIndex)
            minIndex = minIndex.coerceAtMost(i)
        }
        return maxWidth
    }

}