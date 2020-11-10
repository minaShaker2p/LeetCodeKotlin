package easy

import data_structure.BinaryTreeNode

fun isBalanced(root: BinaryTreeNode<Int>?): Boolean {
    return true
}

fun getHeight(node: BinaryTreeNode<Int>?): Int {
    var sum = 0
    if (node?.leftChild != null && node?.rightChild != null)
        return sum
    else
        return 1;


}