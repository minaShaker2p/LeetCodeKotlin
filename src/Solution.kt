import easy.*
import medium.FindMissingObservations2028
import medium.ListNode
import medium.SpiralMatrixIV2326
import medium.WalkingRobotSimulation874

fun main(args: Array<String>) {

    val head = ListNode(0)
    var curr: ListNode? = head
    val array = intArrayOf(3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0)
    array.forEach {
        curr?.next = ListNode(it)
        curr = curr?.next
    }
    SpiralMatrixIV2326.spiralMatrix(m = 3, n = 5, head = head.next)
    // println(FindMissingObservations2028.missingRolls(intArrayOf(3, 5, 3), 5, 3).toString())

}
