package trees

import utils.BinaryTreeNode

fun <T> BinaryTreeNode<T>?.getHeight():Int
{
    if(this?.left==null && this?.right== null)
        return 0
    else {
        var leftHeight =+ 1 + this.left.getHeight()
        var rightHeight =+ 1 + this.right.getHeight()

        return if(leftHeight > rightHeight)  leftHeight else rightHeight
    }
}


