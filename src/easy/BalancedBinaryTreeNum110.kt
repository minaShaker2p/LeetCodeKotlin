package easy

import utils.BinaryTreeNode

fun isBalanced(root: BinaryTreeNode<Int>?): Boolean {
    return true
}

fun getHeight(node: BinaryTreeNode<Int>?): Int {
    var sum = 0
    if (node?.left != null && node?.right != null)
        return sum
    else
        return 1;


}