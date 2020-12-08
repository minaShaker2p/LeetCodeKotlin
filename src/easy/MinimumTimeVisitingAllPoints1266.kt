package easy

import java.lang.Math.max
import kotlin.math.abs
import kotlin.math.min

/*
On a plane there are n points with integer coordinates points[i] = [xi, yi]. Your task is to find the minimum time in seconds to visit all points.

You can move according to the next rules:

In one second always you can either move vertically, horizontally by one unit or diagonally (it means to move one unit vertically and one unit horizontally in one second).
You have to visit the points in the same order as they appear in the array.


Example 1:


Input: points = [[1,1],[3,4],[-1,0]]
Output: 7
Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
Time from [1,1] to [3,4] = 3 seconds
Time from [3,4] to [-1,0] = 4 seconds
Total time = 7 seconds
 */

fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
    var minTime=0
    for (i in 0 until points.size-1)
    {
        minTime+= distance(point1 = points[i],point2 = points[i+1])
    }

    return minTime
}

private fun distance(point1:IntArray,point2: IntArray):Int
{
    return max(abs(point1[0]-point2[0]), abs(point1[1]-point2[1]))
}