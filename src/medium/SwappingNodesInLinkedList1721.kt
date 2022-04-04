package medium

/**
 * You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).



Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]


Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 105
0 <= Node.val <= 100
 */
fun swapNodes(head: ListNode?, k: Int): ListNode? {
    var size=0
    var h=head
    while (h!=null)
    {
        size++
        h=h.next
    }

    val array=IntArray(size)

    var i=0
     h=head
    while (h!=null)
    {
        array[i++]=h.`val`
        h=h.next
    }

    // Swap
    val temp = array[k-1]
    array[k-1]=array[size-k]
    array[size-k]=temp

    var tempNode :ListNode?= ListNode(0)
    val newHead=tempNode

    for(i in 0 until size)
    {
        tempNode?.next=ListNode(array[i])
        tempNode=tempNode?.next
    }

    return newHead?.next
}