package easy

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
Example 4:

Input: nums = [1,3,5,6], target = 0
Output: 0
Example 5:

Input: nums = [1], target = 0
Output: 0


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */
fun searchInsert(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.size-1

    while (end >= start)
    {
        var mid = start + (end-start)/2

        if(nums[mid] == target)
            return mid

        if (target < nums[mid])
            end = mid-1
        else
            start = mid+1
    }
    return end+1

}