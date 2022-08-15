package easy

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.



Example 1:

Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
↑   ↑
The above arrows point to positions where the corresponding bits are different.
Example 2:

Input: x = 3, y = 1
Output: 1


Constraints:

0 <= x, y <= 231 - 1
 */
fun hammingDistance(x: Int, y: Int): Int {
    var xor = x.xor(y)
    // count number of bits using brain kerneghen Algorithm
    var count =0
    while (xor!=0)
    {
        xor=xor.and(xor-1)
        count++
    }
return count
}