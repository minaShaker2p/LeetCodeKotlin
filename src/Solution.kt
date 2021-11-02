import arrays.nextGreaterElement
import data_structure.BinaryTreeNode
import data_structure.ListNode
import easy.*
import medium.MyCalendar
import medium.findDuplicate
import medium.longestStrChain
import medium.solve

fun main(args: Array<String>) {
    //findDuplicate(arrayOf("root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"))
   //longestStrChain(arrayOf("a","b","ba","bca","bda","bdca"))
    //[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

   val  array = arrayOf(charArrayOf('X','X','X','X'),charArrayOf('X','O','O','X'),charArrayOf('X','X','O','X'),charArrayOf('X','O','X','X') )
   solve(array)
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