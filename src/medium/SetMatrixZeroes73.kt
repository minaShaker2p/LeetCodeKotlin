package medium

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.

You must do it in place.



Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]


Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1


Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */
fun setZeroes(matrix: Array<IntArray>): Unit {
val zeroes = mutableListOf<Pair<Int,Int>>()
    val m = matrix.size
    val n = matrix[0].size
    matrix.forEachIndexed { i, row ->
        row.forEachIndexed { j, num ->
            if(num==0)
                zeroes.add(Pair(i,j))
        }
    }

    zeroes.forEach { zero->
         for (i in 0 until m)
            matrix[i][zero.second]=0

             for(j in 0 until n)
                 matrix[zero.first][j]=0
    }
}