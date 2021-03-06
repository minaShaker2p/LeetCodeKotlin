package easy
/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */
fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    for(i in nums.indices)
    {
        for(j in i+1 until nums.size)
        {
            if(nums[i]==nums[j] && (j-i)<=k)
                return true
        }
    }

    return false
}
/*
Another solution with better performance
decrease time form O(N^2) TO O(N)
 */
fun containsNearbyDuplicateSolutionII(nums: IntArray, k: Int): Boolean {
    val map=HashMap<Int,Int>()
    nums.forEachIndexed {i,current->
        if(map.containsKey(current) && (i- map[current]!! ) <=k )
        {
            return true
        }else
        {
            map[current]=i
        }
    }
    return false
}



