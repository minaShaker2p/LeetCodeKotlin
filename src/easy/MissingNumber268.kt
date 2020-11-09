package easy

fun missingNumber(nums: IntArray): Int {
    val max = nums.max() ?: 0
    var missing = -1
    for (i in 0..max) {
        if (!nums.contains(i))
            missing = i
    }

    return if (missing == -1) max + 1 else missing
}