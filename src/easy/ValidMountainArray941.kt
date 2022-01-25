package easy

/**
 *
 * Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Example 1:

Input: arr = [2,1]
Output: false
Example 2:

Input: arr = [3,5,5]
Output: false
Example 3:

Input: arr = [0,3,2,1]
Output: true


Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 104

 */

fun validMountainArray(arr: IntArray): Boolean {
    if(arr.size<3) return false

    // find the index of max value

    var max = Int.MIN_VALUE
    var maxIndex = -1

    for(i in arr.indices)
    {
        if(arr[i]>max)
        {
            max= arr[i]
            maxIndex=i
        }
    }

    // check if maxIndex is not first or last item in the array

    if(maxIndex == 0 || maxIndex == arr.size-1)
        return false

    // check if the array values from 0 until maxIndex increasing
    // arr[i] < arr[i+1] <arr[i+2] ... arr[maxIndex-1]
    for(i in 0 until maxIndex-1)
    {
        if(arr[i]>=arr[i+1])
            return false
    }

    // check if the array values from  maxIndex until to array size -1 decreasing
    // arr[maxIndex] > arr[maxIndex+1] > ... arr[arr.size-1]
    for(i in  maxIndex until arr.size-1)
    {
        if(arr[i]<=arr[i+1])
            return false
    }

    return true
}
