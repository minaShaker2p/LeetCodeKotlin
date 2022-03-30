package medium

/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.


Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
 */
fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val m = matrix.size
    val n = matrix[0].size

    // find the target row
    var row=-1
    for(i in 0 until m)
    {
        if(target>=matrix[i][0]&&target<=matrix[i][n-1])
            row=i
    }
          if(row==-1) return false
    // search in target row
    for(i in 0 until n)
    {
        if(target==matrix[row][i])
            return true
    }
    return false
}