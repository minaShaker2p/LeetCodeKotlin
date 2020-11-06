package trees

import utils.BinaryTreeNode
import kotlin.math.max

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
fun <T> BinaryTreeNode<T>?.getHeight(node :BinaryTreeNode<T>?):Int
{
   return  node?.let { 1+ max(getHeight(node.left),getHeight(node.right)) } ?:-1
}

