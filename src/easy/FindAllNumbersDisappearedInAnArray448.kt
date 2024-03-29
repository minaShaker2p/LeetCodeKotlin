package easy

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.



Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]


Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n


Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val map = HashMap<Int,Int>()

    // initialize the map key from 1 to n with zero
    (1..nums.size).forEach { map[it]=0 }

    for(i in nums.indices)
    {
        map[nums[i]]= (map[nums[i]]?:0)+1
    }

    return map.filter { entry ->entry.value==0  }.keys.toList()
}