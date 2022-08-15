package easy

/**
 * Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.



Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16
Example 3:

Input: n = 3
Output: false


Constraints:
-231 <= n <= 231 - 1

 */
fun isPowerOfTwo(n: Int): Boolean {
    var num = n
    while (num!=0)
    {
        if(num == 1) return true
        if (num %2!=0) return false
        num/=2
    }
    return false

}

fun isPowerOfTwoSol2(n: Int): Boolean {
   if(n<=0) return false
    return n.and(n-1)==0

}