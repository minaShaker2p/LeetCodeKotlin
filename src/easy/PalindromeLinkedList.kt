package easy

import data_structure.ListNode

fun isPalindrome(head: ListNode<Int>?): Boolean {
    var headReverse = head?.reverse()
    var head1 = head
    while (head1 != null && headReverse != null) {
        if (head1.value != headReverse.value) {
            return false
        }
        head1 = head1.next
        headReverse = headReverse.next

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