package easy

/*
Given an array of integers arr, replace each element with its rank.

The rank represents how large the element is. The rank has the following rules:

Rank is an integer starting from 1.
The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
Rank should be as small as possible.

Example 1:

Input: arr = [40,10,20,30]
Output: [4,1,2,3]
Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
Example 2:

Input: arr = [100,100,100]
Output: [1,1,1]
Explanation: Same elements share the same rank.
Example 3:

Input: arr = [37,12,28,9,100,56,80,5,12]
Output: [5,3,4,2,8,6,7,1,3]
 */

fun arrayRankTransform(arr: IntArray): IntArray {
    arr.sort()
    val rankArray=arrayListOf<Int>()
    val smallest=arr[0]
    rankArray.add(1)
    for (i in 1 until arr.size)
    {
        if(arr[i]==smallest)
        { rankArray.add(rankArray[i-1])}

        else
        {
            val value=rankArray[i-1]+1
            rankArray.add(value)
        }

    }
    return rankArray.toIntArray()

}