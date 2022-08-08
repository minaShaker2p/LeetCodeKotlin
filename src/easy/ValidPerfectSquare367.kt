package easy

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as sqrt.



Example 1:

Input: num = 16
Output: true
Example 2:

Input: num = 14
Output: false
 */
fun isPerfectSquare(num: Int): Boolean {

    var start =1
    var end =num
    while (start<=end)
    {
        val mid = ((start+end)/2).toLong()
        val square = mid * mid
        if(square.toInt() == num) return true

        if(square<num)
            start = mid.toInt() +1
        else
            end = mid.toInt() -1
    }
    return false
}