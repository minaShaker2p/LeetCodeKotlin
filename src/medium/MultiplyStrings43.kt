package medium

import java.lang.StringBuilder

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.



Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"


Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
fun multiply(num1: String, num2: String): String {
    val m = num1.length
    val n = num2.length

    if(n ==0 || m==0 || num1 =="0" || num2 == "0")  return "0"

    if(num1=="1" ) return num2

    if(num2 == "1") return  num1

    val result = IntArray(m+n)

    for( i in m-1 downTo 0)
    {
        for( j in n-1 downTo 0)
        {
            var multiply = (num1[i]-'0') * (num2[j]-'0')
            multiply+=result[i+j+1]

            result[i+j+1]= multiply%10
            result[i+j] += multiply/10
        }
    }
    val builder =StringBuilder()
    for (i in result.indices)
    {
        if(builder.isEmpty() && result[i]==0)
            continue
        builder.append(result[i])
    }
    return builder.toString()
}