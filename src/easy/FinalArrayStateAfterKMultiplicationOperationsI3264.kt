package easy

object FinalArrayStateAfterKMultiplicationOperationsI3264 {
    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        // Iterate over the array k times
        (0 until k).forEach { i ->

            // find the minimum element in the array
            var minimumElementIndex = 0
            for (j in nums.indices) {
                if (nums[j] < nums[minimumElementIndex])
                    minimumElementIndex = j
            }
            nums[minimumElementIndex] = nums[minimumElementIndex] * multiplier
        }

        return nums
    }
}