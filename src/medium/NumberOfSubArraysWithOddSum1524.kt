package medium

object NumberOfSubArraysWithOddSum1524 {
    fun numOfSubarrays(arr: IntArray): Int {
        // Calculate all sub arrays
        val subArrays = mutableListOf<List<Int>>()
        for (i in arr.indices) {
            for (j in i + 1..arr.size) {
                subArrays.add(arr.copyOfRange(i, j ).toList())
            }
        }

        // Calculate the sum of each sub array
        var oddSumCount = 0L
        for(subArray in subArrays)
        {
            if(subArray.sum()%2==1)
                oddSumCount++
        }

        // Return number of odd  sum sub array
        return  (oddSumCount % 1000000007).toInt()
    }
}