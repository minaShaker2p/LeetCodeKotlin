package medium

object FindTheNumberOfDistinctColorsAmongTheBalls3160 {
    fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
        val balls = IntArray(limit + 1) { -1 }

        for (query in queries) {
            balls[query[0]] = query[1]
        }

        val colorFreq = HashMap<Int, Int>()

        for (ball in balls) {
            colorFreq[ball] = colorFreq.getOrDefault(ball, 0) + 1
        }

        val result = mutableListOf<Int>()
        for (i in balls.indices)
        {
            if(colorFreq.getOrDefault(balls[i],0)==1)
                result.add(i)
        }
        return result.toIntArray()
    }
}