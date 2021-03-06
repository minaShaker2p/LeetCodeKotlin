package easy

/*
Given an array of integers numbers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.

You may assume that each input would have exactly one solution and you may not use the same element twice.

 Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
 */
fun twoSum(numbers: IntArray, target: Int): IntArray {
    val result = IntArray(2)

    for (i in numbers.indices) {
        for (j in i + 1 until numbers.size) {
            if (numbers[i] + numbers[j] == target) {
                result[0] = i + 1
                result[1] = j + 1
            }
        }
    }

    return result
}
/*
another solution with 2 pointers
enhanced solution with better performance
 */

fun twoSumSolution2(numbers: IntArray, target: Int): IntArray {
    var first=0
    var last = numbers.size-1
    while (first<last)
    {
        if(numbers[first]+numbers[last]==target)
            break
        else if(numbers[first]+numbers[last]>target)
            last--
        else
            first++
    }
    return intArrayOf(first+1,last+1)
}