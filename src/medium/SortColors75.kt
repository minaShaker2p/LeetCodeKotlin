package medium

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.



Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
Example 3:

Input: nums = [0]
Output: [0]
Example 4:

Input: nums = [1]
Output: [1]


Constraints:

n == nums.length
1 <= n <= 300
nums[i] is 0, 1, or 2.

 */

fun sortColors(nums: IntArray): Unit {

    var zeros = 0
    var ones = 0
    var twos = 0

    nums.forEach { num->
        if(num == 0)
            zeros++

        if(num == 1)
            ones++

        if(num == 2)
            twos++
    }

    var counter =0

    for(i in 0 until zeros)
        nums[counter++]=0
    for(i in 0 until ones)
        nums[counter++]=1
    for(i in 0 until twos)
        nums[counter++]=2

}