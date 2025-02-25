package medium

object NumberOfSubArraysWithOddSum1524 {
    fun numOfSubarrays(arr: IntArray): Int {
        val MOD = 1_000_000_007
        var oddCount = 0
        var evenCount = 1
        var count = 0
        var prefixSum = 0
        for (num in arr) {
            prefixSum += num
            // if it is  odd prefix sum, add even count to the count
            if (prefixSum % 2 == 1) {
                count += evenCount
                oddCount++
            } else {
                count += oddCount
                evenCount++
            }
            count %=MOD
        }

        return count
    }
}