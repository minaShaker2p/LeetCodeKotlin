package easy

/*
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time.

Return that integer.

Example 1:

Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6
 */

fun findSpecialInteger(arr: IntArray): Int {
    val map = HashMap<Int, Int>()
    arr.forEach {
        val value = map[it] ?: 0
        map[it] = value.plus(1)
    }
    var result =-1
    map.forEach { (k, v) ->
        if(v > (arr.size/4))
            result=k
    }
    return result

}