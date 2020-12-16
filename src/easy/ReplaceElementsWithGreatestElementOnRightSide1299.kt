package easy

/*
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.
Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
 */

fun replaceElements(arr: IntArray): IntArray {
    arr.forEachIndexed { i, _ ->
        arr[i] = arr.copyOfRange(i + 1, arr.size).getMaxElement()
    }
    return arr

}

fun IntArray.getMaxElement(): Int {
    if(this.isNotEmpty())
    {
        var max = this[0]
        for (i in 1 until this.size) {
            if (this[i] > max)
                max = this[i]
        }
        return max
    }
    return -1
}