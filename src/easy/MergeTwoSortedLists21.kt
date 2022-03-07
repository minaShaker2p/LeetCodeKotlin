package easy

import medium.ListNode

/**
 * You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.



Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 */
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var l1 = list1
    var l2 = list2
    var head = ListNode(0)
    var curr: ListNode? = head
    while (l1 != null && l2 != null) {
        if (l1.`val` < l2.`val`) {
            curr?.next = l1
            l1 = l1.next
        } else {
            curr?.next = l2
            l2 = l2.next
        }
        curr = curr?.next
    }

    while (l1 != null) {
        curr?.next = l1
        l1 = l1.next
        curr = curr?.next
    }
    while (l2 != null) {
        curr?.next = l2
        l2 = l2.next
        curr = curr?.next

    }
    return head.next
}