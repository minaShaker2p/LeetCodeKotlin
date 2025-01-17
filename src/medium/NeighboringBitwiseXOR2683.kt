package medium

object NeighboringBitwiseXOR2683 {
    fun doesValidArrayExist(derived: IntArray): Boolean {
        // Create an original array initialized with 0
        val original  = IntArray(derived.size+1)
        original[0]=0
        for(i in derived.indices)
        {
            original[i+1]=derived[i] xor original[i]
        }

        // Store the validation results in checkForZero and checkForOne respectively
        val checkForZero = original[0] == original[original.size-1]

        original[0]=1
        for(i in derived.indices)
        {
            original[i+1]=derived[i] xor original[i]
        }
        val checkForOne = original[0] == original[original.size-1]

        return checkForZero || checkForOne
    }
}