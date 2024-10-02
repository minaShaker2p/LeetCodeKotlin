package easy

object RankTransformOfAnArray1331 {
    fun arrayRankTransform(arr: IntArray): IntArray {
       // Store the rank of each number in arr
        val numToRank = HashMap<Int, Int>()
        val sortedArray = arr.sortedArray()
        var rank =1
        for (i in sortedArray.indices) {
            if(i > 0 && sortedArray[i-1] < sortedArray[i])
                rank++

            numToRank[sortedArray[i]]= rank
        }
        val result = IntArray(arr.size)
        for (i in arr.indices) {
            result[i] = numToRank.getOrDefault(arr[i],0)
        }
        return result
    }
}