package easy

import kotlin.math.min

/**
We have n chips, where the position of the ith chip is position[i].

We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:

position[i] + 2 or position[i] - 2 with cost = 0.
position[i] + 1 or position[i] - 1 with cost = 1.
Return the minimum cost needed to move all the chips to the same position.

Example 1:

Input: position = [1,2,3]
Output: 1
Explanation: First step: Move the chip at position 3 to position 1 with cost = 0.
Second step: Move the chip at position 2 to position 1 with cost = 1.
Total cost is 1.
 **/

fun minCostToMoveChips(position: IntArray): Int {

    var even = 0
    var odd=0

    position.forEach{
        if(it%2==0)
            even++
        else
            odd++
    }

    return min(even,odd)
}
