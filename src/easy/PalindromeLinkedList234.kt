package easy

import data_structure.ListNode

fun isPalindrome(head: ListNode<Int>?): Boolean {
    var slow: ListNode<Int>? = head
    var fast: ListNode<Int>? = head
    while (fast?.next != null) {

        fast = fast.next?.next
        slow = slow?.next
    }

    slow = slow?.reverse()
    fast = head
    while (slow != null && fast != null) {
        if (slow.value != fast.value)
            return false
        slow =slow.next
        fast=fast.next
    }

    return true

}

fun <T> ListNode<T>.reverse(): ListNode<T>? {
    var previousNode: ListNode<T>? = null
    var currentNode: ListNode<T>? = this

    while (currentNode != null) {
        val nextNode: ListNode<T>? = currentNode.next
        currentNode.next = previousNode
        previousNode = currentNode
        currentNode = nextNode
    }
    return previousNode
}