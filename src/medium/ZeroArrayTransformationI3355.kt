package medium

object ZeroArrayTransformationI3355 {
    fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
        val deltaArray = IntArray(nums.size + 1)

        for (query in queries) {
            val left = query[0]
            val right = query[1]
            deltaArray[left] += 1
            deltaArray[right + 1] -= 1
        }

        val operationCounts = IntArray(deltaArray.size)
        var currentOperations = 0

        for (i in deltaArray.indices) {
            currentOperations += deltaArray[i]
            operationCounts[i] = currentOperations
        }

        for (i in nums.indices) {
            if (operationCounts[i] < nums[i])
                return false
        }

        return true
    }
}