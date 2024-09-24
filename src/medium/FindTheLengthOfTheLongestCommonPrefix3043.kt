package medium

object FindTheLengthOfTheLongestCommonPrefix3043 {
    fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        var result = Int.MIN_VALUE
        for (num1 in arr1) {
            for (num2 in arr2) {
                val prefixCount = num1.toString().prefix(num2.toString())
                result = result.coerceAtLeast(prefixCount)
            }
        }
        return result
    }

    private fun String.prefix(string: String): Int {
        var count = 0
        for (i in indices) {
            if (i < this.length && i < string.length && this[i] == string[i])
                count++
            else
                break
        }
        return count
    }

}