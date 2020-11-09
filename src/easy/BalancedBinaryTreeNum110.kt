package easy

import utils.BinaryTreeNode

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