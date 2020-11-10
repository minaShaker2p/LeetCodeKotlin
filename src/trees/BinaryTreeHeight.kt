package trees

import data_structure.BinaryTreeNode
import kotlin.math.max

fun <T> BinaryTreeNode<T>?.getHeight():Int
{
    if(this?.leftChild==null && this?.rightChild== null)
        return 0
    else {
        var leftHeight =+ 1 + this.leftChild.getHeight()
        var rightHeight =+ 1 + this.rightChild.getHeight()

        return if(leftHeight > rightHeight)  leftHeight else rightHeight
    }
}
fun <T> BinaryTreeNode<T>?.getHeight(node :BinaryTreeNode<T>?):Int
{
   return  node?.let { 1+ max(getHeight(node.leftChild),getHeight(node.rightChild)) } ?:-1
}

