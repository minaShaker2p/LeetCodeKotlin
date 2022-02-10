package medium

/**
 * Given an array of integers nums and an integer k,
 * return the total number of continuous subarrays whose sum equals to k.



Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

 */
fun subarraySum(nums: IntArray, k: Int): Int {
    var count=0

    val arrSum = HashMap<Int,Int>()
    var sum =0
    arrSum[sum]=1

    for(i in nums.indices)
    {
        sum+=nums[i]

        if(arrSum.containsKey(sum-k))
            count+=arrSum[sum-k]?:0

        arrSum[sum]= arrSum.getOrDefault(sum,0)+1
    }
    return count

}