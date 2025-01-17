package medium

object NeighboringBitwiseXOR2683 {
    fun doesValidArrayExist(derived: IntArray): Boolean {
        var ans = 0

        derived.forEach { num ->
            ans = ans xor num
        }

        return ans == 0
    }
}