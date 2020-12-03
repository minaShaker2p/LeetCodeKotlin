package easy

/*
On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively.
 Uppercase characters represent white pieces, and lowercase characters represent black pieces.

The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south),
 then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.

Return the number of pawns the rook can capture in one move.

 Example 1
Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
Output: 3
Explanation:
In this example the rook is able to capture all the pawns.
 */
fun numRookCaptures(board: Array<CharArray>): Int {

    var iRockIndex =0
    var jRockIndex=0
    var pawns=0

    for ( i in board.indices)
    {
        for(j in board[i].indices)
        {
            if(board[i][j]=='R')
            {
                iRockIndex=i
                jRockIndex=j
                break
            }
        }
    }
    //move east
    for (i in jRockIndex until board[iRockIndex].size)
    {
        if(board[iRockIndex][i]=='B')
            break
        if(board[iRockIndex][i]=='p') {
            pawns++
            break
        }

    }

    //move west
    for (i in jRockIndex downTo  0)
    {
        if(board[iRockIndex][i]=='B')
            break
        if(board[iRockIndex][i]=='p') {
            pawns++
            break
        }
    }

    //move South
    for (i in iRockIndex until board.size)
    {
        if(board[i][jRockIndex]=='B')
            break
        if(board[i][jRockIndex]=='p') {
            pawns++
            break
        }
    }

    //move north
    for (i in iRockIndex downTo  0)
    {
        if(board[i][jRockIndex]=='B')
            break
        if(board[i][jRockIndex]=='p') {
            pawns++
            break
        }
    }

    return pawns
}