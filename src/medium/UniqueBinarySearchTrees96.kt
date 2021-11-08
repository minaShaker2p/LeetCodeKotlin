package medium

/**
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.



Example 1:


Input: n = 3
Output: 5
Example 2:

Input: n = 1
Output: 1


Constraints:

1 <= n <= 19
 */

class UniqueBinarySearchTrees{
    val dp =IntArray(20)
    fun numTrees(n: Int): Int {

        if(n <= 1) return 1
        if(dp[n]>0) return dp[n]
        for(i in 1 ..n)
        {
            dp[n]+=numTrees(i-1) * numTrees(n-i)
        }
        return dp[n]
    }
}
