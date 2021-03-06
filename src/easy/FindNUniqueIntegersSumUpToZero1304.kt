package easy

/*
Given an integer n, return any array containing n unique integers such that they add up to 0.
Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
Example 2:

Input: n = 3
Output: [-1,0,1]
Example 3:

Input: n = 1
Output: [0]
 */
fun sumZero(n: Int): IntArray {
    val result = arrayListOf<Int>()
    if(n==1)
        return intArrayOf(0)
    else
    {

        for(i in 1..n/2)
        {
            result.add(i)
            result.add(i*-1)
        }
        if(n%2==1)
        {
            // in case it is negative number
            result.add(0)
        }
    }
    return result.toIntArray()
}