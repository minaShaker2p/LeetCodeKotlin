package medium

fun getLucky(s: String, k: Int): Int {
    val builder = StringBuilder()
    s.forEach { char ->
        builder.append((char - 'a') + 1)
    }

    var numericString = builder.toString()

    repeat(k) {
        var digitSum = 0
        numericString.forEach { digitChar ->
            digitSum += digitChar - '0'
        }
        numericString = digitSum.toString()
    }
    return numericString.toInt()
}