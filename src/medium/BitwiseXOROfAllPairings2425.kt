package medium

object BitwiseXOROfAllPairings2425 {
    fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
        val pairsList = mutableListOf<Int>()

        for (n1 in nums1) {
            for (n2 in nums2) {
                val xorPair = n1 xor n2
                pairsList.add(xorPair)
            }
        }
        var result = pairsList[0]
        for (i in 1 until pairsList.size)
        {
            result = result xor pairsList[i]
        }
        return result
    }
}