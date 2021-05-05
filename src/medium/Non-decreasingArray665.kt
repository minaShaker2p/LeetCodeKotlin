package medium

/**
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

Example 1:

Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:

Input: nums = [4,2,1]
Output: false
Explanation: You can't get a non-decreasing array by modify at most one element.

 **/

fun checkPossibility(nums: IntArray): Boolean {
    var pos =-1
    for( i in 0 until nums.size-1)
    {
        if(nums[i] > nums[i+1])
        {
            if(pos!=-1)
                return false
            pos = i
        }
    }

    return pos == -1 || pos ==0 || pos == nums.size-2 || nums[pos-1] <= nums[pos+1] || nums[pos] <= nums[pos+2]
}