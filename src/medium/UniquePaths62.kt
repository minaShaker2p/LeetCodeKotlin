package medium

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?



Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:

Input: m = 7, n = 3
Output: 28
Example 4:

Input: m = 3, n = 3
Output: 6
 */
fun uniquePaths(m: Int, n: Int): Int {
    val dp = Array(m){IntArray(n)}
    for(i in 0 until m)
        dp[i][0]=1

    for(i in 0 until n)
        dp[0][i]=1

    for (i in 1 until m)
        for(j in 1 until n)
        dp[i][j]= dp[i-1][j]+dp[i][j-1]


    return dp[m-1][n-1]
}

var count=0
fun uniquePathsSol2(m: Int, n: Int): Int {
    countUniquePaths(m, n,0, 0)
return count
}

fun countUniquePaths(m: Int, n: Int, i: Int, j:Int) {
if(i>=m || j >= n) return

    if (i==m-1 && j == n-1) count++

    countUniquePaths(m,n,i+1,j)
    countUniquePaths(m,n,i,j+1)
}
