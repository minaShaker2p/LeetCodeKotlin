package medium

object LongestSquareStreakInArray2501 {
    fun longestSquareStreak(nums: IntArray): Int {
        val setOfNums = nums.toSet()
        val setOSquares = mutableSetOf<Int>()
        for (num in nums) {
            val squareOfNum = num * num
            if (setOfNums.contains(squareOfNum)) {
                setOSquares.add(num)
                setOSquares.add(squareOfNum)
            }
        }

        // sort the set of squares
        val sortedSetOfSquares = setOSquares.sorted()

        var longestSquareStreak = 0
        var streak = 0

        for(i in 1 until sortedSetOfSquares.size)
        {
            if((sortedSetOfSquares[i-1] * sortedSetOfSquares[i-1])  != sortedSetOfSquares[i])
            {
                streak=0
            }else
            {
                streak++
            }
            longestSquareStreak =  Math.max(longestSquareStreak,streak)
        }
        if(longestSquareStreak == 0) return -1

        return longestSquareStreak
    }
}