package easy

/**
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal.
Each group of children is separated by the null value (See examples)

Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]
*/
class Node(var `val`: Int) {
         var children: List<Node?> = listOf()
     }

class Solution {
    val list = mutableListOf<Int>()
    fun preorder(root: Node?): List<Int> {

        return list
    }
}