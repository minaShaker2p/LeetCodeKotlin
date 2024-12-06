package medium

object MaximumNumberOfIntegersToChooseFromRangeI2554 {
    fun maxCount(banned: IntArray, n: Int, maxSum: Int): Int {
        val bannedSet = mutableSetOf<Int>()

        // Keep the banned numbers that are less than n in a set
        for (num in banned) {
            bannedSet.add(num)
        }

        // Loop over the numbers from 1 to n and if the number is not banned, use it
        var sum = 0
        var maxCount = 0
        for (i in 1..n) {
            if(bannedSet.contains(i)) continue

            if (sum + i <= maxSum) {
                sum += i
                maxCount++
            }

        }
        return maxCount
    }
}