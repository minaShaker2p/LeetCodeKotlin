package medium

object SpiralMatrixIV2326 {
    fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
        // Store the east, south, west, north movements in a matrix
        var row = 0
        var col = 0
        var currDir = 0
        val movements = arrayOf(
            intArrayOf(0, 1),//East
            intArrayOf(1, 0), //South
            intArrayOf(0, -1), //West
            intArrayOf(-1, 0) //North
        )
        var currNode = head
        // Create the matrix
        val matrix = Array(m) { IntArray(n) { -1 } }

        while (currNode != null) {
            matrix[row][col] = head?.`val` ?: -1
            val newRow = row + movements[currDir][0]
            val newCol = col + movements[currDir][1]

            // If we bump into an edge or an already filled cell, change the direction
            if (newRow < 0 || newCol < 0 || newRow >= m || newCol >= n || matrix[newRow][newCol] != -1) {
                currDir = (currDir + 1) % 4
            }

            row += movements[currDir][0]
            col += movements[currDir][1]

            currNode = currNode.next
        }

        return matrix
    }
}