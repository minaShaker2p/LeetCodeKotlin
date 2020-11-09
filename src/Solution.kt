import trees.deserialize
import trees.serialize
import utils.BinaryTreeNode

fun main(args:Array<String>) {
    val tree=makeTree()
    val list=tree.serialize()
    println(list)
    println(tree.deserialize(list))
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