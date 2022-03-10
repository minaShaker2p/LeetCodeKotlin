package medium

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 */
fun addTwoNumbers(list1: ListNode?, list2: ListNode?): ListNode? {
    val head=ListNode(0)
    var curr= head
    var l1=list1
    var l2=list2
    var remain = 0
    while (l1!=null && l2!=null)
    {
        var sum= l1.`val`+l2.`val`+remain
        if (sum>9)
        {
            sum-=10
            remain=1
        }else
            remain=0
        curr.next=ListNode(sum)
        curr=curr.next!!
        l1=l1.next
        l2=l2.next
    }
    // if list1 still has nodes
    while (l1!=null )
    {
        var sum= l1.`val`+remain
        if (sum>9)
        {
            sum-=10
            remain=1
        }else
            remain=0

        curr.next=ListNode(sum)
        curr=curr.next!!
        l1=l1.next
    }

    while ( l2!=null)
    {
        var sum= l2.`val`+remain
        if (sum>9)
        {
            sum-=10
            remain=1
        }else
            remain=0
        curr.next=ListNode(sum)
        curr=curr.next!!
        l2=l2.next
    }
    if(remain==1)
        curr.next=ListNode(1)

    return head.next

}