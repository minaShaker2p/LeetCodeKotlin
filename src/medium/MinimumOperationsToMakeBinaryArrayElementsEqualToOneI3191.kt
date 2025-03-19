package medium

object MinimumOperationsToMakeBinaryArrayElementsEqualToOneI3191 {
    fun minOperations(nums: IntArray): Int {
        // initialize count to track the number of flip operations
        var count = 0

        // Itarate through num starting from 2nd element
        for (i in 2 until nums.size) {
            if (nums[i - 2] == 0) {
                count++
                nums[i - 2] = nums[i - 2].xor(1)
                nums[i - 1] = nums[i - 1].xor(1)
                nums[i] = nums[i].xor(1)
            }
        }

        return if (nums.sum() == nums.size) count else -1
    }
}