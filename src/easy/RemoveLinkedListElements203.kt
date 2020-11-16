package easy

import data_structure.ListNode

/**
 * Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 **/

fun removeElements(head: ListNode<Int>?, `val`: Int): ListNode<Int>? {
    var prev: ListNode<Int>? = null

    var newHead = head

    while (newHead != null && newHead.value == `val`) {
        newHead = newHead?.next
    }
    var current = newHead

    while (current != null) {
        if (current.value == `val`) {
            prev?.next = current.next
            current = prev?.next
            continue
        }
        // update previous element
        prev = current
        current = current.next
    }

    return newHead
}
