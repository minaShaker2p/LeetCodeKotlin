package easy

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.



Example 1:


Input: root = [1,null,2,3]
Output: [1,3,2]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */
val list= mutableListOf<Int>()
fun inorderTraversal(root: TreeNode?): List<Int> {
    if(root==null)
        return emptyList()
    inorderTraversal(root?.left)
    list.add(root.`val` ?:0)
    inorderTraversal(root?.right)
return list
}