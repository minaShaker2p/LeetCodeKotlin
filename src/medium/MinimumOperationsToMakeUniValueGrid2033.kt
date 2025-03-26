package medium

object MinimumOperationsToMakeUniValueGrid2033 {
    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        // Create an empty array to store all numbers
        val numsArray = mutableListOf<Int>()
        // To store the total number of operations
        var result = 0

        // Flatten the grid into numsArray, by iterating over its elements and pushing them into it
        grid.forEach { row ->
            row.forEach { num ->
                numsArray.add(num)
            }
        }

        // Sort numsArray in non-decreasing order
        numsArray.sort()
        val length = numsArray.size
        val finalCommonNumber = numsArray[length/2]

        for(num in numsArray)
        {
            if((num %x) != (finalCommonNumber%x))
            {
                return -1
            }else
            {
                result+=Math.abs(finalCommonNumber-num)/x
            }
        }

        return result
    }
}