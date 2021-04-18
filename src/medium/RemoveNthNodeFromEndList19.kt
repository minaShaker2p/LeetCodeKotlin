package medium

import data_structure.ListNode

/**
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Follow up: Could you do this in one pass?



Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 * */


fun removeNthFromEnd(head: ListNode<Int>?, n: Int): ListNode<Int>? {
    var h =head
    val dummy = ListNode(0)
    dummy.next=h

    var len =0

    while (h !=null) {
        h = h.next
        len++
    }
    var  current : ListNode<Int>?=dummy
    var i =0
    var  limit=len-n
    while (i<limit)
    {
        current=current?.next
        i++
    }
     current?.next=current?.next?.next

    return dummy.next

}