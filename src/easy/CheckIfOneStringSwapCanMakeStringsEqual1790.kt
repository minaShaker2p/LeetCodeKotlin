package easy

object CheckIfOneStringSwapCanMakeStringsEqual1790 {
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        val mapS1 = HashMap<Char, Int>()
        val mapS2 = HashMap<Char, Int>()
        s1.forEach { char ->
            mapS1[char] = mapS1.getOrDefault(char, 0) + 1
        }

        s2.forEach { char ->
            mapS2[char] = mapS2.getOrDefault(char, 0) + 1
        }

        for (k in mapS1.keys) {
            if (mapS1[k] != mapS2[k])
                return false
        }

        var numOfUnmatch = 0
        s1.forEachIndexed { index, char ->
            if (s1[index] != s2[index])
                numOfUnmatch++
        }

        return numOfUnmatch == 2 || numOfUnmatch == 0
    }
}