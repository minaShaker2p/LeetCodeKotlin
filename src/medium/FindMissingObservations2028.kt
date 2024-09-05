package medium

object FindMissingObservations2028 {

    fun missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {
        val m = rolls.size
        // Calculate the sum
        var sum = 0
        rolls.forEach{roll->
            sum+=roll
        }

        // Calculate the remaining sum
        val remainingSum = (mean * (n+m)) - sum

        // Check if the sum is valid or not

        if(remainingSum > 6*n || remainingSum < n)
            return intArrayOf()

        val distributeMean = remainingSum / n
        val mod = remainingSum % n;

        // Distribute the remaining mod element in nElements array

        val result = Array<Int>(n){distributeMean}
        for(i in 0 until mod)
            result[i]=result[i]+1

        return result.toIntArray()
    }
}