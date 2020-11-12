package arrays

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
 **/
//Solution Time complexity O(N) and space Complexity is O(1)
fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var maxCon = 0
    var count = 0
    nums.forEachIndexed { index, n ->
        if (n == 1) {
            count++
        }
        if (n == 0 || index == nums.size - 1) {
            if (maxCon < count) {
                maxCon = count
            }
            count = 0
        }
    }
    return maxCon
}
