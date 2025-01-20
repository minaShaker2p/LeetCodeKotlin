package medium

object FirstCompletelyPaintedRowOrColumn2661 {

    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size
        arr.forEachIndexed { index, value ->
            for (i in mat.indices) {
                for (j in mat[0].indices) {
                    if (mat[i][j] == value) {
                        // paint this cell
                        mat[i][j] = -mat[i][j]
                    }
                    // check for the completely painted row or column
                    if (checkRow(i, mat) || checkCol(j, mat))
                        return index
                }
            }
        }
        return 0
    }

    private fun checkRow(row: Int, mat: Array<IntArray>): Boolean {
        val n = mat[0].size
        for (col in 0 until n) {
            if (mat[row][col] >= 0)
                return false
        }
        return true
    }

    private fun checkCol(col: Int, mat: Array<IntArray>): Boolean {
        val m = mat.size
        for (row in 0 until m) {
            if (mat[row][col] >= 0)
                return false
        }
        return true
    }

}