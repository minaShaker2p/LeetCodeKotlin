package medium

object MaxSumOfPairWithEqualSumOfDigits2342 {
    fun maximumSum(nums: IntArray): Int {
        val sumToIndices = HashMap<Int, MutableList<Int>>()

        nums.forEachIndexed { index, num ->
            val digitSum = calculateDigitSum(num)
            val indicesList = sumToIndices.getOrDefault(digitSum, mutableListOf())
            indicesList.add(index)
            sumToIndices[digitSum] = indicesList
        }

        var result = -1

        for ((_, v) in sumToIndices) {
            if (v.size >= 2) {
                for (i in 0 until v.size - 1) {
                    for (j in i + 1 until v.size) {
                        result = Math.max(result, nums[v[i]] + nums[v[j]])
                    }
                }

            }
        }

        return result
    }

    private fun calculateDigitSum(num: Int): Int {
        var digitSum = 0
        var tempNum = num
        while (tempNum != 0) {
            digitSum += tempNum % 10
            tempNum /= 10
        }
        return digitSum
    }
}