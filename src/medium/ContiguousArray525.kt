package medium

/**
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.



Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
 */
fun findMaxLength(nums: IntArray): Int {
    var maxLength = 0

    val counts = HashMap<Int, Int>()
    counts[0]=-1
    var count = 0

    for (i in nums.indices) {
        count += if(nums[i]==0)
            -1
        else
            1

        if(counts.containsKey(count))
            maxLength= Math.max(maxLength,i- (counts[count]?:0))
        else
            counts[count]=i
    }

    return maxLength
}