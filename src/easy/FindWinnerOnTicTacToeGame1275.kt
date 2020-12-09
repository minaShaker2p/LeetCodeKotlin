package easy

/*
Tic-tac-toe is played by two players A and B on a 3 x 3 grid.

Here are the rules of Tic-Tac-Toe:

Players take turns placing characters into empty squares (" ").
The first player A always places "X" characters, while the second player B always places "O" characters.
"X" and "O" characters are always placed into empty squares, never on filled ones.
The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Given an array moves where each element is another array of size 2 corresponding to the row and column of the grid where they mark their respective character in the order in which A and B play.

Return the winner of the game if it exists (A or B), in case the game ends in a draw return "Draw", if there are still movements to play return "Pending".

You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the grid is initially empty and A will play first.



Example 1:

Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: "A" wins, he always plays first.
"X  "    "X  "    "X  "    "X  "    "X  "
"   " -> "   " -> " X " -> " X " -> " X "
"   "    "O  "    "O  "    "OO "    "OOX"
Example 2:

Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
Output: "B"
Explanation: "B" wins.
"X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
"   " -> " O " -> " O " -> " O " -> "XO " -> "XO "
"   "    "   "    "   "    "   "    "   "    "O  "
Example 3:

Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
Output: "Draw"
Explanation: The game ends in a draw since there are no moves to make.
"XXO"
"OOX"
"XOX"
 */

fun tictactoe(moves: Array<IntArray>): String {
    val board = Array(3) { CharArray(3) {' '} }

    moves.forEachIndexed { i, move ->
        var player = 'O'
        if (i % 2 == 0)
            player = 'X'
        board[move[0]][move[1]] = player
    }
    // check rows
    board.forEachIndexed { i, row ->
        if (row[0] == 'X' && row[1] == 'X' && row[2] == 'X')
            return "A"
        else if (row[0] == 'O' && row[1] == 'O' && row[2] == 'O')
            return "B"
    }

    // check columns
    for (i in 0 until 3) {
        if (board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X')
            return "A"
        else if (board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == 'O')
            return "B"
    }

    // check diagonals

    for (i in 0 until 3) {
        if ((board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')||
            (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')  )
            return "A"
        else  if ((board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')||
            (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')  )
            return "B"
    }
    if (moves.size<9)
        return "Pending"
    return "Draw"
}