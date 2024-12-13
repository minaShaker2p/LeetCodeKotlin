package medium

object FindScoreOfAnArrayAfterMarkingAllElements2593 {
    fun findScore(nums: IntArray): Long {
        //  Keep track marked nums
        //  unmarked -> false
        //  marked -> true
        val markedNum = BooleanArray(nums.size) { false }

        var score = 0L

        // Iterate over the array until all items are marked
        while (markedNum.isAllItemsMarked().not()) {
            // Iterate over the array items to find the smallest unmarked number
            var smallestNumIndex = -1
            var smallestNum = Int.MAX_VALUE
            for (i in nums.indices) {
                if (markedNum[i].not() && nums[i] < smallestNum) {
                    smallestNum = nums[i]
                    smallestNumIndex = i
                }
            }
            markedNum[smallestNumIndex] =true
            if (smallestNumIndex > 0)
                markedNum[smallestNumIndex - 1] = true
            if (smallestNumIndex < nums.size - 1)
                markedNum[smallestNumIndex + 1] = true
            score += smallestNum
        }

        return score
    }

    // Extension function to check if the all array elements are marked
    private fun BooleanArray.isAllItemsMarked(): Boolean {
        return this.all { it }
    }
}