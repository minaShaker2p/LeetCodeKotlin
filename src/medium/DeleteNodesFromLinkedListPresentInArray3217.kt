package medium

object DeleteNodesFromLinkedListPresentInArray3217 {
    fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
        var tempHead = head
        var prev : ListNode?= null
        var curr = tempHead

        while(curr!=null)
        {
            //check if the current value exists in the nums array
            val currentValue= curr?.`val`?:0
            if(nums.contains(currentValue).not())
            {
                // skip to delete this node and move to the next node
                prev = curr
                curr = curr.next
            }else
            {
                // delete this node
                if(prev == null)
                {
                    // this node is a head, so delete the head
                    var temp = tempHead
                    tempHead = tempHead?.next
                    temp = null
                    curr = tempHead
                    prev = curr
                    curr = curr?.next
                }else
                {
                    var temp = curr
                    curr = curr?.next
                    prev?.next = curr
                    temp = null
                }
            }
        }
        return tempHead

    }
}