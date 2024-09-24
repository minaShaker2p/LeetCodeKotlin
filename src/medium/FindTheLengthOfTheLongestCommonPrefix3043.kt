package medium

import kotlin.math.log10

object FindTheLengthOfTheLongestCommonPrefix3043 {
    fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        // Store all prefixes from arr1
        val arr1Prefixes = arr1.buildPrefixes()

        // initialize longestPrefix to 0 keep track of the length of the longest common prefix
        var longestPrefix = 0

        // Iterate over each val in arr2
        arr2.forEach { num ->
            var currNum = num
            // While currNum is not in arr1Prefixes and currNum is greater than 0
            // Then reduce the currNum by removing the last digit
            while (arr1Prefixes.contains(currNum).not() && currNum > 0) {
                currNum /= 10
            }
            // If currentNum is greater than o and matching the prefix is found
            // Update longestPrefix to the maximum of its current value and the length of the matched prefix (calculating using log10(val) +1)
            if (arr1Prefixes.contains(currNum))
                longestPrefix = longestPrefix.coerceAtLeast(log10(currNum.toDouble()).plus(1).toInt())
        }

        return longestPrefix
    }

    private fun IntArray.buildPrefixes(): Set<Int> {
        val prefixes = mutableSetOf<Int>()
        this.forEach { num ->
            var currNum = num
            while (currNum != 0) {
                prefixes.add(currNum)
                currNum /= 10
            }
        }
        return prefixes
    }

}