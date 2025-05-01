package easy

object CountSpecialQuadruplets1995 {
    //1.brute force
    //Time: O(N^4); Space: O(1)
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

    fun countQuadrupletsSOL2(nums: IntArray): Int {
        val freqMap = HashMap<Int,Int>()
        val n =  nums.size
        var count = 0

        for(i in n-2 downTo  1)
        {
            for (j in i+1 until n)
            {
                val sum = nums[j]-nums[i]
                freqMap[sum]=freqMap.getOrDefault(sum,0)+1
            }

            for (j in i-2 downTo  0)
            {
                val sum = nums[j]+nums[i-1]
                count+=freqMap.getOrDefault(sum,0)
            }
        }
        return count
    }
}