package medium

/**
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.



Example 1:


Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
Example 2:


Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]


Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.


Follow up:

Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?
 */
val directions = arrayOf(
    arrayOf(0, 1),
    arrayOf(0, -1),
    arrayOf(1, 0),
    arrayOf(-1, 0),
    arrayOf(-1, -1),
    arrayOf(-1, 1),
    arrayOf(1, 1),
    arrayOf(1, -1)
)

fun gameOfLife(board: Array<IntArray>): Unit {
    // if cell is live and the active neighbours fewer than 2 or larger than 3 then dies
    // if dead cell surrounded by exactly three active neighbours then become live cell

    val m = board.size
    val n =board[0].size
    for(i in 0 until m)
    {
        for(j in 0 until n)
        {
            val activeNeighbours = getActiveNeigbours(board,i,j)
            if(board[i][j]==1&& (activeNeighbours<2||activeNeighbours>3))
                board[i][j]=-2
            else if(board[i][j]==0&& activeNeighbours==3)
                board[i][j]=3
        }
    }
    updateBoard(board)

}

fun updateBoard(board: Array<IntArray>) {
    val m = board.size
    val n = board[0].size
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (board[i][j] == -2)
                board[i][j] = 0
            if (board[i][j] == 3)
                board[i][j] = 1
        }
    }
}

fun getActiveNeigbours(board: Array<IntArray>, r: Int, c: Int) :Int{
    var count=0
    for (direction in directions) {
        val row = r + direction[0]
        val col = c + direction[1]

        if(row>=0 && row<board.size && col>=0 && col<board[0].size)
        {
            if(board[row][col]==1 || board[row][col]==-2)
                count++
        }
    }
    return count
}