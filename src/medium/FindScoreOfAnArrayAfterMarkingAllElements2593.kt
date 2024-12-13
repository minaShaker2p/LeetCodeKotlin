package medium

object FindScoreOfAnArrayAfterMarkingAllElements2593 {
    fun findScore(nums: IntArray): Long {
        var score = 0L
        val sorted = Array(nums.size) { IntArray(2) }
        val marked = BooleanArray(nums.size)

        for (i in nums.indices) {
            sorted[i][0] = nums[i]
            sorted[i][1] = i
        }

        // sort the array
        sorted.sortWith(comparator = { arr1, arr2 -> arr1[0] - arr2[0] })

        for (i in nums.indices) {
            val number = sorted[i][0]
            val index = sorted[i][1]
            if (marked[index].not()) {
                score += number
                marked[index]=true
                // mark adjacent elements if they exist
                if (index - 1 >= 0) {
                    marked[index - 1] = true
                }
                if (index + 1 < nums.size) {
                    marked[index + 1] = true
                }
            }

        }
        return score
    }

}