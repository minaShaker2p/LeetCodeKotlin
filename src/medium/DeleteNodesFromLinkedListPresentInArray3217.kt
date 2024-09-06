package medium

object DeleteNodesFromLinkedListPresentInArray3217 {

    fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
        var currentHead = head

        // Handle the case where the head node needs to be removed
        while(currentHead !=null && nums.contains(currentHead.`val`))
        {
            currentHead = currentHead.next
        }

        // If the list is empty after removing head node, return null
        if(head == null) return null

        // Iterate through the list, removing nodes with values in the set
        var curr = currentHead

        while(curr?.next != null)
        {
            if(nums.contains(curr.next?.`val`?:0))
            {
                // Skip the next node by updating the pointer
                curr.next = curr.next?.next
            }else
            {
                curr= curr.next
            }
        }

        return currentHead
    }
}