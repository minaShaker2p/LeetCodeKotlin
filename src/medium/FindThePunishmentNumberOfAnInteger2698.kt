package medium

object FindThePunishmentNumberOfAnInteger2698 {
    private fun findPartitions(
        startIndex: Int,
        sum: Int,
        stringNum: String,
        target: Int,
        memo: Array<IntArray>
    ): Boolean {

        // Check if the partition is valid
        if (startIndex == stringNum.length) {
            return sum == target
        }

        // Invalid partition found, so we return false
        if (sum > target) {
            return false
        }

        // If the result for this state is already calculated, return it
        if (memo[startIndex][sum] != -1) {
            return memo[startIndex][sum] == 1
        }

        var partitionFound = false

        // Iterate through all possible substrings starting with startIndex
        for (currentIndex in startIndex until stringNum.length) {
            // Create partition
            val currentString = stringNum.substring(startIndex, currentIndex + 1)

            val added = currentString.toInt()

            // Recursively check if valid partition can be found
            partitionFound = partitionFound || findPartitions(
                startIndex = currentIndex + 1,
                sum = sum + added,
                stringNum = stringNum,
                target = target,
                memo = memo
            )

            if (partitionFound) {
                memo[startIndex][sum] = 1
                return true
            }
        }

        // Memorize the result for future reference and return its result
        memo[startIndex][sum] = 0
        return false

    }

    fun punishmentNumber(n: Int): Int {
        var punishmentNum = 0
        // Iterate through numbers in range [1,n]
        for (currentNum in 1 .. n) {
            val squareNum = currentNum * currentNum
            val stringNum = squareNum.toString()

            // Initialize value in memorization array
            val memoArray = Array(stringNum.length) { IntArray(currentNum + 1) { -1 } }

            // Check if valid partition can be found and add squared number if so
            if (findPartitions(
                    startIndex = 0,
                    sum = 0,
                    stringNum = stringNum,
                    target = currentNum,
                    memo = memoArray
                )
            ) {

                punishmentNum += squareNum
            }
        }
        return punishmentNum
    }
}