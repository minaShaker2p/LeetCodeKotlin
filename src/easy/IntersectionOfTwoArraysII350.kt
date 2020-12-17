package easy

/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk,
and the memory is limited such that you cannot load all elements into the memory at once?
 */
fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val result = arrayListOf<Int>()
    val map1 = nums1.toHashTable()

    nums2.forEachIndexed{i, num ->
        if(map1.containsKey(num)&& (map1[num]!!>= 1))
        {
            result.add(num)
            val value=map1[num]?:0
            map1[num]=value-1
        }
    }

    return result.toIntArray()
}

fun IntArray.toHashTable(): HashMap<Int, Int> {
    val map = HashMap<Int, Int>()
    this.forEach {
        val value = map[it] ?: 0
        map[it] = value + 1
    }
    return map
}

