package medium

object StringCompressionIII3163 {
    fun compressedString(word: String): String {
        val compressedString = StringBuilder()
        val runString = StringBuilder()
        for (char in word) {

            if (runString.isEmpty() || (runString.last() == char && runString.length<9)) {
                runString.append(char)
            } else {
                compressedString.append(runString.length)
                compressedString.append(runString.last())
                runString.clear()
                runString.append(char)
            }
        }
        if(runString.isNotEmpty())
        {
            compressedString.append(runString.length)
            compressedString.append(runString.last())
        }
        return compressedString.toString()
    }
}