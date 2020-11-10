import easy.missingNumber
import data_structure.BinaryTreeNode

fun main(args:Array<String>) {
    println(missingNumber(intArrayOf(1)))
    println(missingNumber(intArrayOf(0,1)))
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