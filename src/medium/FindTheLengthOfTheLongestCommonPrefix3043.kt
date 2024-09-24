package medium

object FindTheLengthOfTheLongestCommonPrefix3043 {
    fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        // Store all prefixes from arr1
        val arr1Prefixes = arr1.buildPrefixes()

        // initialize longestPrefix to 0 keep track of the length of the longest common prefix
        var longestPrefix = 0

        // Iterate over each val in arr2
        arr2.forEach { num ->
            var currNum = num
            while (arr1Prefixes.contains(currNum).not() && currNum > 0) {
                currNum /= 10
            }

            if (arr1Prefixes.contains(currNum))
                longestPrefix = longestPrefix.coerceAtLeast(currNum.toString().length)
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