package medium

/**
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]


Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
 **/

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {

    val result = mutableSetOf<List<Int>>()
      nums.sort()
    for(a in 0 until nums.size-3)
        for( b in a+1 until nums.size-2)
        {
            for(c in b+1 until nums.size-1)
            {
                for(d in c+1 until nums.size)
                {
                    val sum = nums[a] + nums[b] + nums[c] + nums[d]
                    if(sum == target)
                        result.add(listOf(nums[a],nums[b],nums[c],nums[d]))
                }
            }
        }
    return result.toList()
}