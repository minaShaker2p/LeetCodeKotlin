import arrays.nextGreaterElement
import data_structure.BinaryTreeNode
import data_structure.ListNode
import easy.*

fun main(args: Array<String>) {
countLargestGroup(13)
}

fun makeSingleLinkedList(): ListNode<Int> {
    val head = ListNode(1)
    val t1 = ListNode(1)
    val t2 = ListNode(2)
    val t3 = ListNode(6)
    val t4 = ListNode(3)
    val t5 = ListNode(4)
    val t6 = ListNode(5)
    val t7 = ListNode(6)
    head.next = t1
    t1.next = t2
    t2.next = t3
    t3.next = t4
    t4.next = t5
    t5.next = t6
    t6.next = t7
    return head
}

fun makeTree(): BinaryTreeNode<Int> {
    val zero = BinaryTreeNode(0)
    val one = BinaryTreeNode(1)
    val five = BinaryTreeNode(5)
    val seven = BinaryTreeNode(7)
    val eight = BinaryTreeNode(8)
    val nine = BinaryTreeNode(9)

    seven.leftChild = one
    one.leftChild = zero
    one.rightChild = five
    seven.rightChild = nine
    nine.rightChild = eight

    return seven
}