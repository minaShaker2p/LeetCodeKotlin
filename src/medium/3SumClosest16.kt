package medium

import kotlin.math.abs

/**
 * Share
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


Constraints:

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4

 */

fun threeSumClosest(nums: IntArray, target: Int): Int {
    val size = nums.size
    var result = nums[0]+nums[1]+nums[size-1]

    nums.sort()

    for(i in  0 until size-2)
    {
        var low = i+1
        var high = size-1
        while (low < high)
        {
            val  currentSum = nums[i]+nums[low]+nums[high]
            if(currentSum < target)
                low++
            else
                high--

            if(Math.abs(target-currentSum) < Math.abs(result- target))
                result= currentSum
        }
    }

    return result
}