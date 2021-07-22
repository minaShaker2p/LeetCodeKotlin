package medium

import java.lang.StringBuilder

/**
 * There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.

After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

You are given a string dominoes representing the initial state where:

dominoes[i] = 'L', if the ith domino has been pushed to the left,
dominoes[i] = 'R', if the ith domino has been pushed to the right, and
dominoes[i] = '.', if the ith domino has not been pushed.
Return a string representing the final state.

Example 1:

Input: dominoes = "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.
Example 2:


Input: dominoes = ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."


Constraints:

n == dominoes.length
1 <= n <= 105
dominoes[i] is either 'L', 'R', or '.'.
 */

fun pushDominoes(dominoes: String): String {
    val n = dominoes.length
    val forces = IntArray(n)
    val builder = StringBuilder()

    var force = 0

    for( i in 0 until dominoes.length)
    {
        force = when {
            dominoes[i] == 'R' -> n
            dominoes[i] == 'L' -> 0
            else -> Math.max(force-1,0)
        }
        forces[i] += force
    }

     force = 0

    for( i in dominoes.length-1 downTo 0)
    {
        force = when {
            dominoes[i] == 'L' -> n
            dominoes[i] == 'R' -> 0
            else -> Math.max(force-1,0)
        }
        forces[i] -= force
    }

    forces.forEach {force->
        when {
            force > 0 -> builder.append('R')
            force < 0 -> builder.append('L')
            else -> builder.append('.')
        }
    }





    return builder.toString()
}