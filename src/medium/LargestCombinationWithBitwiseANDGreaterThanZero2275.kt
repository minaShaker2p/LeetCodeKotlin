package medium

object LargestCombinationWithBitwiseANDGreaterThanZero2275 {
    fun largestCombination(candidates: IntArray): Int {
        // Initialize an array to store the count of each bit position
        val bitCount = IntArray(24)

         for (i in 0 until 24)
         {
             candidates.forEach { candidate->
                 // Check if ths i-th bit is set
                 val one = 1
                 if((candidate.and(one.shl(i)))!=0)
                 {
                     bitCount[i]++
                 }
             }

         }

        return bitCount.max()

    }
}