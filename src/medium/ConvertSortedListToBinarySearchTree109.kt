package medium

/**

Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Example 1:

Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [0]
Output: [0]
Example 4:

Input: head = [1,3]
Output: [3,1]
 **/

fun sortedListToBST(head: ListNode?): TreeNode? {
    if(head ==null)
        return null

    var middle = getMiddleNode(head)
    var  root =TreeNode(middle!!.`val`)

    if(head == middle)
        return root

    root.left = sortedListToBST(head)
    root.right = sortedListToBST(middle.next)
    return root
}

fun getMiddleNode(head: ListNode?) : ListNode?
{
    var slow = head
    var fast =head
    var prev : ListNode? = null

    while (fast!=null && fast.next!=null)
    {
        prev = slow
        slow =slow?.next
        fast= fast.next?.next
    }
    if(prev !=null)
        prev.next=null

    return  slow

}
 class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
    }
class ListNode(var `val`: Int) {
         var next: ListNode? = null
    }