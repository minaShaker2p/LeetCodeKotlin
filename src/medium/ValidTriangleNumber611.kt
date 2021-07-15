package medium

/**
 * Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.



Example 1:

Input: nums = [2,2,3,4]
Output: 3
Explanation: Valid combinations are:
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
Example 2:

Input: nums = [4,2,3,4]
Output: 4


Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 1000
 **/
// Brute force solution
// O(n^3)
fun triangleNumberBruteForce(nums: IntArray): Int {
     var count = 0

    for(i in 0 until nums.size-2)
    {
        for(j in i+1 until nums.size-1)
        {
            for( k in j+1 until nums.size)
            {
                if(nums[i]+nums[j] > nums[k] && nums[j]+nums[k] > nums[i] && nums[i]+nums[k] > nums[j])
                    count++
            }
        }
    }

    return count
}

// O(n^2)
fun triangleNumber(nums: IntArray): Int {
    var count =0
    nums.sort()
    for (i in 2 until nums.size)
    {
        var left = 0
        var right = i-1
        while (left < right)
        {
            if(nums[left]+nums[right] > nums[i])
            {
                count+=right-left
                right--
            }else
                left++
        }
    }
    return count

}