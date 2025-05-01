package easy

object CountSpecialQuadruplets1995 {
    fun countQuadruplets(nums: IntArray): Int {
        val n = nums.size
        var count = 0

        for (i in 0 until n - 3) {
            for (j in i + 1 until n - 2) {
                for (k in j + 1 until n - 1) {
                    for (l in k + 1 until n) {
                        val sum = nums[i] + nums[j] + nums[k]
                        if (sum == nums[l])
                            count++
                    }
                }
            }
        }

        return count
    }
}