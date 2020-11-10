package trees

import data_structure.BinaryTreeNode

fun <T> BinaryTreeNode<T>.traversePreOrderWithNull(visit: (T?) -> Unit) {
    visit(value)
    leftChild?.traversePreOrderWithNull(visit) ?: visit(null)
    rightChild?.traversePreOrderWithNull(visit) ?: visit(null)
}

fun <T> BinaryTreeNode<T>.serialize(node: BinaryTreeNode<T> = this): MutableList<T?> {
    val list = mutableListOf<T?>()

    node.traversePreOrderWithNull { list.add(it) }
    return list
}

fun <T> BinaryTreeNode<T>.deserialize(list: MutableList<T?>): BinaryTreeNode<T?>? {
    val rootValue = list.removeAt(0)?: return null// require O(N) as time complexity
    val root = BinaryTreeNode<T?>(rootValue)

    root.leftChild = deserialize(list)
    root.rightChild = deserialize(list)
    return root

}