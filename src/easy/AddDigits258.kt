package easy

/**
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.



Example 1:

Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2
Since 2 has only one digit, return it.
Example 2:

Input: num = 0
Output: 0


Constraints:

0 <= num <= 231 - 1
 */

fun addDigits(num: Int): Int {
    var sum = 0
    var n = num

    while (n!=0 || sum >9)
    {
        sum+=n%10
        n/=10
        var temp = sum
        sum =0
        while (temp!=0 || sum > 9)
        {
            sum+=temp%10
            temp/=10
        }
    }
    return sum
}