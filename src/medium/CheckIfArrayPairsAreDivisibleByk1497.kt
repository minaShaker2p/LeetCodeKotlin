package medium

import java.util.HashSet

object CheckIfArrayPairsAreDivisibleByk1497 {
    fun canArrange(arr: IntArray, k: Int): Boolean {
        val remainderCount = HashMap<Int, Int>()

        // Store the count of the remainder in a map
        arr.forEach { num ->
            val rem = ((num % k) + k) % k
            remainderCount[rem] = remainderCount.getOrDefault(rem, 0) + 1
        }

        arr.forEach { num ->
            val rem = ((num % k) + k) % k
            // If the remainder for an element is 0 , the  count
            // of numbers that give this remainder must be even.
            if (rem == 0) {
                if ((remainderCount.getOrDefault(rem, 0) % 2) == 1) return false
            }

            // If the remainder rem and k-m do not have the
            // same count then pairs can not be made
            else if (remainderCount.getOrDefault(rem, 0) != remainderCount.getOrDefault((k - rem), 0)) {
                return false
            }
        }
            return true
    }
}