package medium

/**
 * Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.

In one move, you can increment or decrement an element of the array by 1.
Example 1:

Input: nums = [1,2,3]
Output: 2
Explanation:
Only two moves are needed (remember each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
Example 2:

Input: nums = [1,10,2,9]
Output: 16


Constraints:

n == nums.length
1 <= nums.length <= 105
-109 <= nums[i] <= 109
 */
fun minMoves2(nums: IntArray): Int {
    var moves = 0
    // sort O(NLogN)
    nums.sort()

    val pivot = nums.size / 2

    for( i in nums.indices)
    {
        if(i<pivot)
            moves += nums[pivot] - nums[i]
        else
            moves += nums[i] - nums[pivot]
    }

return moves
}