package easy

object MinimumTimeToTypeWordUsingSpecialTypewriter1974 {
    fun minTimeToType(word: String): Int {
        var minTime = word.length
        minTime += clockwiseDistance(word[0], 'a').coerceAtMost(counterClockwiseDistance(word[0], 'a'))

        for (i in 1 until word.length)
        {
            val clockwise = clockwiseDistance(word[i],word[i-1])
            val counterClockwise = counterClockwiseDistance(word[i],word[i-1])
            minTime+= clockwise.coerceAtMost(counterClockwise)
        }
        return minTime
    }

    private fun counterClockwiseDistance(from: Char, to: Char): Int {
        val start = from.lowercaseChar() - 'a'
        val end = to.lowercaseChar() - 'a'
        return (start - end + 26) % 26
    }
    private fun clockwiseDistance(from: Char, to: Char): Int {
        val start = from.lowercaseChar() - 'a'
        val end = to.lowercaseChar() - 'a'
        return (end - start + 26) % 26
    }
}