package medium

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.



Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []


Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
 */
fun sortList(head: ListNode?): ListNode? {

    if(head?.next == null) return head

    var prev:ListNode?=null
    var slow = head
    var fast = head
    while (fast?.next != null)
    {
        prev= slow
        slow=slow?.next
        fast=fast.next?.next
    }
    prev?.next=null
    val first = sortList(head)
    val second = sortList(slow)
return merge(first,second)
}

fun merge(first: ListNode?,second: ListNode?):ListNode?
{
    var temp:ListNode?=ListNode(0)
    val dummy = temp
    var head1= first
    var head2 = second
    while (head1!=null&&head2!=null)
    {
        if(head1.`val`<head2.`val`)
        {
            temp?.next=head1
            head1=head1.next
        }else
        {
            temp?.next=head2
            head2=head2.next
        }
        temp=temp?.next
    }

    while (head1!=null)
    {
        temp?.next=head1
        head1=head1.next
        temp=temp?.next
    }

    while (head2!=null)
    {
        temp?.next=head2
        head2=head2.next
        temp=temp?.next
    }
    return dummy?.next
}