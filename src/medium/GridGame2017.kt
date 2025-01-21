package medium

object GridGame2017 {
    fun gridGame(grid: Array<IntArray>): Long {
        // Calculate the sun of all element for the first row
        var firstRowSum = 0L
        grid[0].forEach { num ->
            firstRowSum += num
        }

        var secondRowSum = 0L
        var minimumSum = Long.MAX_VALUE

        for (turnIndex in grid[0].indices) {
            firstRowSum -= grid[0][turnIndex]
            // Find the minimum value out of firstRowSum and secondRowSum
            minimumSum = Math.min(minimumSum, Math.max(firstRowSum, secondRowSum))
            secondRowSum += grid[1][turnIndex]
        }
        return minimumSum
    }
}