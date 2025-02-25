package medium

object NumberOfSubArraysWithOddSum1524 {
    fun numOfSubarrays(arr: IntArray): Int {
        val MOD = 1000000007
        var oddSumCount = 0
        for (i in arr.indices) {
            var count = 0
            for (j in i..<arr.size) {
                count += arr[j]
                if (count % 2 == 1)
                    oddSumCount++
            }
        }

        return (oddSumCount % MOD)
    }
}