package medium

object SplitStringIntoTheMaxNumberOfUniqueSubstrings {
    fun maxUniqueSplit(s: String): Int {
        val uniqueSubstrings = mutableSetOf<String>()
        var curr = 0
        while (curr < s.length) {

            val subString = StringBuilder()
            subString.append(s[curr])
            if (uniqueSubstrings.contains(subString.toString()).not()) {
              uniqueSubstrings.add(uniqueSubstrings.toString())
                curr++
                continue
            }else
            {
                for (j in curr + 1 until s.length) {
                    subString.append(s[j])
                    if (uniqueSubstrings.contains(subString.toString()).not()) {
                        uniqueSubstrings.add(uniqueSubstrings.toString())
                        curr++
                        break
                    }
                }
            }
        }

        return uniqueSubstrings.size
    }
}