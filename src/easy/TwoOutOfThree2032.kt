package easy

object TwoOutOfThree2032 {
    fun twoOutOfThree(nums1: IntArray, nums2: IntArray, nums3: IntArray): List<Int> {
        val freqMap = HashMap<Int, Int>()

        nums1.distinct().forEach { num ->
            freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        }

        nums2.distinct().forEach { num ->
            freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        }

        nums3.distinct().forEach { num ->
            freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        }

        val result = mutableListOf<Int>()
        for ((k, v) in freqMap) {
            if (v >= 2)
                result.add(k)
        }
        return result
    }
}