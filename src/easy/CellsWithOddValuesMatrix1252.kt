package easy

/*
Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] = [ri, ci]. For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.

Return the number of cells with odd values in the matrix after applying the increment to all indices.



Example 1:

Input: n = 2, m = 3, indices = [[0,1],[1,1]]
Output: 6
Explanation: Initial matrix = [[0,0,0],[0,0,0]].
After applying first increment it becomes [[1,2,1],[0,1,0]].
The final matrix will be [[1,3,1],[1,3,1]] which contains 6 odd numbers.
 */

fun oddCells(n: Int, m: Int, indices: Array<IntArray>): Int {

    val array = Array(n) { IntArray(m) }
    for (i in 0 until n)
    {
        for (j in 0 until m)
        {
            array[i][j]=0
        }
    }
    indices.forEach {cell->
        array.forEachIndexed { i,row->
            row.forEachIndexed { j, column ->
                if(cell[0]==i)
                    array[i][j]++
                if(cell[1]==j)
                    array[i][j]++
            }
        }
    }
    var result=0

    for (i in array.indices)
    {
        for (j in array[i].indices)
        {
           if(array[i][j]%2!=0)
               result++
        }
    }
return result
}