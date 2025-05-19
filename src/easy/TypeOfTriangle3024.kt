package easy

object TypeOfTriangle3024 {

    // Approach :Mathematics
    /**
     * First, sort nums in ascending order, then make the following checks in sequence:
     *
     * If nums[0] + nums[1] <= nums[2], return none
     * If nums[0] = nums[2], return "equilateral"
     * If nums[0] = nums[1] or nums[1] = nums[2], return "isosceles"
     * If none of the above conditions are met, return "scalene"
     */

    fun triangleType(nums: IntArray): String {
        nums.sort()

        return if (nums[0] + nums[1] <= nums[2]) {
            "none"
        } else if (nums[0] == nums[2]) {
            "equilateral"
        } else if (nums[0] == nums[1] || nums[1] == nums[2]) {
            "isosceles"
        } else {
            "scalene"
        }
    }
}