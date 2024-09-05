package medium

object FindMissingObservations2028 {

    fun missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {
        val m = rolls.size
        // Calculate the sum
        var sum = 0
        rolls.forEach{roll->
            sum+=roll
        }

        // Calculate x , the sum of the n observations
        val x = (mean * (n+m)) - sum


        // Calculate the array of n (missing) observation

        if(x/n == 0 || x/n >6)
            return intArrayOf()

        val result = Array<Int>(n){0}
            if(x%n !=0)
            {
                for(i in 0 until n-1)
                    result[i]=x/n

                result[n-1]=(x/n)+1
            }else
            {
                for(i in 0 until n)
                    result[i]=x/n
            }


        return result.toIntArray()
    }
}