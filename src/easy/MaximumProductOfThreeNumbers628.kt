package easy

import kotlin.math.abs

/*
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

Example 1:

Input: nums = [1,2,3]
Output: 6
Example 2:

Input: nums = [1,2,3,4]
Output: 24
Example 3:

Input: nums = [-1,-2,-3]
Output: -6
 */
//O(NLogN)
fun maximumProduct(nums: IntArray): Int {
      nums.sort()
      val n=nums.size

    return Math.max((nums[0]*nums[1]*nums[n-1]),(nums[n-3]*nums[n-2]*nums[n-1]))
}