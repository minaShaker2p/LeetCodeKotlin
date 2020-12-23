package arrays

/*
Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.



Example 1:

Input: n = 12
Output: 21
Example 2:

Input: n = 21
Output: -1
 */
fun nextGreaterElement(n: Int): Int {
    val arr= arrayListOf<Int>()
    var previous=-1
    var number=n
    var index=0
    if(number >0)
    {
        arr.add(index,number%10)
        number/=10
        index++

        while(number!=0)
        {
            val temp=number%10
            if(temp<arr[index-1])
            {
                val t= arr[index-1]
                arr[index-1]=temp
                arr[index]=t
                break
            }
        }
        while(number!=0)
        {
            index++
            arr.add(index,number%10)
            number/=10

        }
        var result=0

        arr.forEachIndexed {i,v ->
            result= result+(v)
        }
    }




    return -1

}