package medium

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.



Example 1:

Input: num = 3
Output: "III"
Explanation: 3 is represented as 3 ones.
Example 2:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 3:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


Constraints:

1 <= num <= 3999
 */
fun intToRoman(num: Int): String {
    val map = hashMapOf<Int, String>(
        1 to "I",
        5 to "V",
        10 to "X",
        50 to "L",
        100 to "C",
        500 to "D",
        1000 to "M",
        4 to "IV",
        9 to "IX",
        40 to "XL",
        90 to "XC",
        400 to "CD",
        900 to "CM"
    )
    val builder = StringBuilder()
    var n = num
    while (n != 0) {
        var number = 1
        when {
            n >= 1000 -> number = 1000

            n >= 900 -> number = 900

            n >= 500 -> number = 500

            n >= 400 -> number = 400

            n >= 100 -> number = 100

            n >= 90 -> number = 90

            n >= 50 -> number = 50

            n >= 40 -> number = 40

            n >= 10 -> number = 10

            n >= 9 -> number = 9

            n >= 5 -> number = 5

            n >= 4 -> number = 4

        }
        n -= number
        val ch = map.getOrDefault(number, "I")
        builder.append(ch)

    }
    return builder.toString()
}