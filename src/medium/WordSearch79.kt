package medium

/**
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.



Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false


Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.

 */

fun exist(board: Array<CharArray>, word: String): Boolean {
    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] == word[0] && dfs(board, i, j, 0, word))
                return true
        }
    }
    return false
}

fun dfs(board: Array<CharArray>, currRow: Int, currCol: Int, count: Int, word: String): Boolean {
    if (count == word.length) return true
    if (currRow < 0 || currRow >= board.size || currCol < 0 || currCol >= board[0].size || board[currRow][currCol] != word[count])
        return false
    val temp = board[currRow][currCol]
    board[currRow][currCol]=' '
    val found = dfs(board,currRow+1,currCol,count+1,word)
            ||  dfs(board,currRow-1,currCol,count+1,word)
            ||   dfs(board,currRow,currCol+1,count+1,word)
            ||  dfs(board,currRow,currCol-1,count+1,word)
    board[currRow][currCol]=temp
    return found
}