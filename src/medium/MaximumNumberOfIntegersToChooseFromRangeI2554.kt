package medium

object MaximumNumberOfIntegersToChooseFromRangeI2554 {
    fun maxCount(banned: IntArray, n: Int, maxSum: Int): Int {
        val bannedNumbersInRange = mutableSetOf<Int>()

        // Keep the banned numbers that are less than n in a set
        for (num in banned) {
            if (num <= n)
                bannedNumbersInRange.add(num)
        }

        // Loop over the numbers from 1 to n and if the number is not banned, use it
        var sum = 0
        var maxCount=0
        for(i in 1 ..n)
        {
            if(sum+i<maxSum && bannedNumbersInRange.contains(i).not()){
                sum+=i
                maxCount++
            }

        }
        return maxCount
    }
}