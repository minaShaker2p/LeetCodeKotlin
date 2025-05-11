package easy

object ThreeConsecutiveOdds1550 {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        var odds = 0
        var previousOdd = -1
        arr.forEach { num ->
            when {
                num.issOdd() && previousOdd.issOdd() -> {
                    previousOdd = num
                    odds++
                }

                num % 2 == 1 -> {
                    odds = 1
                    previousOdd = num
                }

                else -> {
                    odds = 0
                    previousOdd = -1
                }
            }

            if (odds == 3)
                return true

        }

        return false
    }

    private fun Int.issOdd() = this % 2 == 1
}