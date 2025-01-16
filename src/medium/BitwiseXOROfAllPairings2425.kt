package medium

object BitwiseXOROfAllPairings2425 {
    fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
     // Get length of Arrays
        val len1= nums1.size
        val len2 = nums2.size

        // Map to store frequency of each number
        val freq = HashMap<Int,Int>()

        // Add frequencies for num1 elements
        // Each element appear n2 times in final result
        for(num in nums1)
        {
            freq[num]=freq.getOrDefault(num,0)+len2
        }

        // Add frequencies for num2 elements
        // Each element appear n1 times in final result
        for(num in nums2)
        {
            freq[num]=freq.getOrDefault(num,0)+len1
        }

        // XOR numbers that appear odd number of times
        var ans = 0
        for((k,v) in freq)
        {
            if(v%2==1)
            {
                ans = ans xor k
            }
        }
        return ans
    }
}