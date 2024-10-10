package medium

object MaximumWidthRamp962 {
    fun maxWidthRamp(nums: IntArray): Int {
        var maxRamp = Int.MIN_VALUE
        for(i in 0 until nums.size-1)
        {
            for(j in i+1 until  nums.size)
            {
                if(nums[i]<nums[j])
                    maxRamp= maxRamp.coerceAtLeast(j - i)
            }
        }
        return maxRamp
    }
}