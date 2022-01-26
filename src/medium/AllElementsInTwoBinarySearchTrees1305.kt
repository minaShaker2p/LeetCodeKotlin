package medium

/**
Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.

Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:


Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]


Constraints:

The number of nodes in each tree is in the range [0, 5000].
-105 <= Node.val <= 105
 */
val list1 = mutableListOf<Int>()
val list2 = mutableListOf<Int>()
fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
traverseInOrderTree1(root1)
    traverseInOrderTree2(root2)
    return merge(list1, list2)
}

fun traverseInOrderTree1(root: TreeNode?)
{
    if(root==null) return

    traverseInOrderTree1(root?.left)
    list1.add(root.`val`)
    traverseInOrderTree1(root.right)

}

fun traverseInOrderTree2(root: TreeNode?)
{
    if(root==null) return

    traverseInOrderTree2(root.left)
    list2.add(root.`val`)
    traverseInOrderTree2(root.right)
}

fun merge(list1: List<Int>,list2: List<Int>) : List<Int>
{
    val result = mutableListOf<Int>()
    var i = 0
    var j = 0
    while (i<list1.size && j < list2.size)
    {
        if(list1[i] < list2[j])
         result.add(list1[i++])
        else
            result.add(list2[j++])
    }

    if(i<list1.size)
    {
        result.addAll(list1.subList(i,list1.size))
    }

    if(j<list2.size)
    {
        result.addAll(list2.subList(j,list2.size))
    }

    return result
}

