/*
 *
 * Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
*/
fun containsDuplicate(nums: IntArray): Boolean {
    val map=HashMap<Int,Int>()
    nums.forEach {
        val temp=map[it]?:0
        map[it]=temp+1
    }
    map.forEach {entry->
     if(entry.value>1)
         return true
    }

    return false
}