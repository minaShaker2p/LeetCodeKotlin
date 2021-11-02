package medium

/**
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.



Example 1:


Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
Example 2:

Input: board = [["X"]]
Output: [["X"]]


Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
 */
fun solve(board: Array<CharArray>): Unit {
 if(board.isEmpty() || board[0].isEmpty())
     return

    val m = board.size
    val n = board[0].size

    // check 'O' in first column
    for(i in 0 until m)
        if(board[i][0]=='O')
            dfsHelper(board,i,0)

    // check 'O' in last column
    for(i in 0 until m)
        if(board[i][n-1]=='O')
            dfsHelper(board,i,n-1)

    // check 'O' in last column
    for(i in 0 until n)
        if(board[i][m-1]=='O')
            dfsHelper(board,i,m-1)

    // check 'O' in first row
    for(i in 0 until n)
        if(board[0][i]=='O')
            dfsHelper(board,0,i)

    // check 'O' in last row
    for(i in 0 until n)
        if(board[n-1][i]=='O')
            dfsHelper(board,n-1,i)

    for(i in 0 until m)
        for(j in 0 until n)
        {
            if(board[i][j]=='O')
                board[i][j]='X'
        }

    for(i in 0 until m)
        for(j in 0 until n)
        {
            if(board[i][j]=='V')
                board[i][j]='O'
        }
}

fun dfsHelper(board: Array<CharArray>,row:Int,column:Int)
{
    if(row <= 0 || column <= 0 || row >= board.size-1 || column >= board.size -1 || board[row][column] == 'X' || board[row][column]== 'V' )
        return

    board[row][column] = 'V'

    dfsHelper(board,row,column+1)
    dfsHelper(board,row,column-1)
    dfsHelper(board,row+1,column)
    dfsHelper(board,row-1,column)


}
