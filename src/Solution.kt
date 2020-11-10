import easy.missingNumber
import data_structure.BinaryTreeNode
import data_structure.ListNode
import easy.isPalindrome
import java.util.*

fun main(args: Array<String>) {
    print(isPalindrome(makeSingleLinkedList()))
}

fun makeSingleLinkedList(): ListNode<Int> {
    val head = ListNode(1)
    val t1 = ListNode(1)
    val t2 = ListNode(2)
    val t3 = ListNode(1)
    head.next = t1
    t1.next = t2
    t2.next = t3
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