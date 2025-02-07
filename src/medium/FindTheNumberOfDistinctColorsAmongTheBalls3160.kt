package medium

object FindTheNumberOfDistinctColorsAmongTheBalls3160 {
    fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
        val n = queries.size
        val result = IntArray(n)
        val colorMap = HashMap<Int, Int>()
        val ballArray = IntArray(limit + 1)

        // Iterate through queries
        for (i in 0 until n) {
            // Extract ball label and color from the query
            val ball = queries[i][0]
            val color = queries[i][1]

            // Check if the ball is already colored
            if (ballArray[ball] != 0) {
                // Decrement the count of the color o the ball
                val prevColor = ballArray[ball]
                colorMap[prevColor] = colorMap.getOrDefault(prevColor, 0) - 1

                // If there are no balls with the previous color left, remove the color from the map
                if (colorMap.getOrDefault(prevColor, 0) == 0) {
                    colorMap.remove(prevColor)
                }
            }
            // Set color of ball to the new color
            ballArray[ball] = color

            // Increment the count of the new color
            colorMap[color] = colorMap.getOrDefault(color, 0) + 1

            result[i]=colorMap.size
        }
        return result
    }
}