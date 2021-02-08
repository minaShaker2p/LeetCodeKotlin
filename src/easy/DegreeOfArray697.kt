package easy

/*
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:

Input: nums = [1,2,2,3,1]
Output: 2
Explanation:
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:

Input: nums = [1,2,2,3,1,4,2]
Output: 6
Explanation:
The degree is 3 because the element 2 is repeated 3 times.
So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.

 */
fun findShortestSubArray(nums: IntArray): Int {
    val map=HashMap<Int,Int>()
    nums.forEach{
        val temp=map[it]?:0
        map[it]=temp+1
    }
    var max=Int.MIN_VALUE
    map.forEach {entry ->
        if(entry.value>max)
            max=entry.value
    }
    val degreeArray=ArrayList<Int>()
    map.forEach { entry ->
        if (entry.value == max)
            degreeArray.add(entry.key)
    }

    var shortest=Int.MAX_VALUE
    degreeArray.forEach {degree->
        var i=0
        var j=nums.size-1
        while (nums[i]!=degree||nums[j]!=degree)
        {
            if(nums[i]!=degree)
                i++
            if(nums[j]!=degree)
                j--
        }
        shortest=Math.min(shortest,(j-i+1))

    }

    return shortest
}