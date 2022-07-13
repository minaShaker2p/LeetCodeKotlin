package medium

/**
 * You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.



Example 1:


Input: matchsticks = [1,1,2,2,2]
Output: true
Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
Example 2:

Input: matchsticks = [3,3,3,3,4]
Output: false
Explanation: You cannot find a way to form a square with all the matchsticks.
 */
fun makesquare(matchsticks: IntArray): Boolean {
    var sum = 0
    matchsticks.forEach { sum += it }
    if (sum % 4 != 0 || matchsticks.size < 4) return false
    val target = sum / 4
    matchsticks.sort()
    return helper(matchsticks,matchsticks.size-1,0,0,0,0,target)
}

fun helper(matchsticks: IntArray, i: Int, sum1: Int, sum2: Int, sum3: Int, sum4: Int, target: Int): Boolean {
    if (sum1 > target || sum2 > target || sum3 > target || sum4 > target) return false

    if (i == -1) {
        return target == sum1 && sum2 == target && sum3 == target && sum4 == target
    }

    return helper(matchsticks,i-1,sum1+matchsticks[i],sum2,sum3,sum4,target) ||
            helper(matchsticks,i-1,sum1,sum2+matchsticks[i],sum3,sum4,target) ||
            helper(matchsticks,i-1,sum1,sum2,sum3+matchsticks[i],sum4,target) ||
            helper(matchsticks,i-1,sum1,sum2,sum3,sum4+matchsticks[i],target)
}