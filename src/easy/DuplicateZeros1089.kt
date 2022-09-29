package easy
/*
Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.



Example 1:

Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:

Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]
 */
fun duplicateZeros(arr: IntArray): Unit {
    val list= mutableListOf<Int>()
    for(i in arr.indices)
    {
        if(arr[i]==0) {
            list.add(0)
            list.add(0)
        }else
            list.add(arr[i])
    }
    for(i in arr.indices)
    {
        arr[i]=list[i]
    }
}
fun duplicateZerosSol2(arr: IntArray): Unit {
   var i=0
    while(i<arr.size)
    {
        if(arr[i]==0)
        {
            for(j in arr.size-1 downTo i+1)
                arr[j]=arr[j-1]
            if(i<arr.size-1)
                arr[i+1]=0
            i+=2
        }else
            i++
    }
}