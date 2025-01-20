package medium

object FirstCompletelyPaintedRowOrColumn2661 {

    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        val numRows = mat.size
        val numCols = mat[0].size
        val numToPos = HashMap<Int, Pair<Int, Int>>()

        // Populate the numToPos map by iterating over the matrix
        for (row in 0 until numRows) {
            for (col in 0 until numCols) {
                val value = mat[row][col]
                numToPos[value] = Pair(row, col)
            }
        }
        arr.forEachIndexed { index, value ->
            val pos: Pair<Int, Int> = numToPos.getOrDefault(value, Pair(0,0))
            val row = pos.first
            val col = pos.second
            mat[row][col]=-mat[row][col]


            // check for the completely painted row or column
            if (checkRow(row, mat) || checkCol(col, mat))
                return index
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