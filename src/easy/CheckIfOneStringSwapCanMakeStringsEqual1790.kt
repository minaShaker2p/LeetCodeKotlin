package easy

object CheckIfOneStringSwapCanMakeStringsEqual1790 {
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        val map = HashMap<Char, Int>()

        s1.forEach { char ->
            map[char] = map.getOrDefault(char, 0) + 1
        }

        s2.forEach { char ->
            map[char] = map.getOrDefault(char, 0) + 1
        }

        for ((k, v) in map) {
            if (v % 2 != 0)
                return false
        }

        return true
    }
}