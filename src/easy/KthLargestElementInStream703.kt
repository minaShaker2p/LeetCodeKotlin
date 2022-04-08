package easy

class KthLargest(k: Int, nums: IntArray) {
    val list=nums.toMutableList()
    val limit=k

    fun add(`val`: Int): Int {
        list.add(`val`)
        list.sort()
        val size=list.size
        var i=1
        var largest=list[size-i]
        while (i<=limit)
        {
            if(largest>list[size-i])
            {
                largest=list[size-i]
            }
            i++

        }
        return largest
    }

}