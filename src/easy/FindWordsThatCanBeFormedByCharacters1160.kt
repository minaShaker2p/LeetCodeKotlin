package easy

fun countCharacters(words: Array<String>, chars: String): Int {
    var length = 0

    if (words.isEmpty() || chars.length > 100 || words.size > 1000)
        return 0

    val charsMap = chars.toCountMap()


    words.forEach { word ->
        val map = word.toCountMap()
        if (map.isFormedBy(charsMap))
            length += word.length
    }
    return length
}

fun HashMap<Char, Int>.isFormedBy(another: HashMap<Char, Int>): Boolean {
    this.forEach {
        if (another.containsKey(it.key)) {
            val value = another[it.key] ?: 0
            if (value < it.value)
                return false
        } else {
            return false
        }
    }
    return true
}

fun String.toCountMap(): HashMap<Char, Int> {
    val map = HashMap<Char, Int>()
    this.forEach {
        val value = map[it] ?: 0
        map[it] = value + 1
    }
    return map
}