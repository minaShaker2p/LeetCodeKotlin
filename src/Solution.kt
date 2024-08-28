import arrays.nextGreaterElement
import data_structure.BinaryTreeNode
import data_structure.ListNode
import easy.*
import medium.*

fun main(args: Array<String>) {
    val grid1 = arrayOf(
        intArrayOf(1, 0, 1, 0, 1),
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 0, 1, 0, 1)
    )

    val grid2 = arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(0, 1, 0, 1, 0),
        intArrayOf(0, 1, 0, 1, 0),
        intArrayOf(1, 0, 0, 0, 1)
    )
    println(countSubIslands(grid1, grid2))

}