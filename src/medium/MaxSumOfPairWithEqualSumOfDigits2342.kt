package medium

object MaxSumOfPairWithEqualSumOfDigits2342 {
    fun maximumSum(nums: IntArray): Int {
        val sumToIndices = HashMap<Int, MutableList<Int>>()

        nums.forEachIndexed { index, _ ->
            var num = nums[index]
            var sumOfDigits = 0
            while (num != 0) {
                sumOfDigits += num % 10
                num /= 10
            }
            val indicesList = sumToIndices.getOrDefault(sumOfDigits, mutableListOf())
            indicesList.add(index)
            sumToIndices[sumOfDigits] = indicesList
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
}