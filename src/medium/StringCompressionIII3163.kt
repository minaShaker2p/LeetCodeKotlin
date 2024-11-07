package medium

object StringCompressionIII3163 {
    fun compressedString(word: String): String {
        val compressedString = StringBuilder()
        val runString = StringBuilder()
        for (char in word) {

            if (runString.isEmpty() || (runString.last() == char && runString.length < 9)) {
                runString.append(char)
            } else {
                compressedString.append(runString.length)
                compressedString.append(runString.last())
                runString.clear()
                runString.append(char)
            }
        }
        if (runString.isNotEmpty()) {
            compressedString.append(runString.length)
            compressedString.append(runString.last())
        }
        return compressedString.toString()
    }

    fun compressedStringSolution2(word: String): String {
        val compressedString = StringBuilder()

        // pos tracks our position in the input string
        var pos = 0

        // process until we reach end of string
        while (pos < word.length) {
            var consecutiveCount = 0
            val currentChar = word[pos]

            // count consecutive occurrence (maximum 9)
            while (pos < word.length && consecutiveCount < 9 &&
                word[pos] == currentChar
            ) {
                consecutiveCount++
                pos++
            }

            // Append count followed by character to result
            compressedString.append(consecutiveCount).append(currentChar)
        }
        return compressedString.toString()
    }
}