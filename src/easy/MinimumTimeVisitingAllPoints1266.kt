package easy

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
    var timeForward = 0
    var timeBackward=0
    for (i in 0 until points.size-1)
    {
        var A =points[i]
        val B =points[i+1]
        while (!A.contentEquals(B))
        {
            if(A[0]<B[0])
            {
                // go Diagonal vertical up
                A = intArrayOf(A[0]+1,A[1]+1)
                timeForward++

            }else if(A[0]>B[0])
            {
                // go Diagonal vertical down
                A = intArrayOf(A[0]-1,A[1]-1)
                timeForward++
            }else
            {
                // in case of x value are equal
                if(A[1]<B[1])
                {
                    //go straight horizontal to right
                    A = intArrayOf(A[0],A[1]+1)
                    timeForward++

                }else if(A[1]>B[1])
                {
                    //go straight horizontal to left
                    A = intArrayOf(A[0],A[1]-1)
                    timeForward++
                }

            }
        }

    }

    for (i in points.size-1 downTo 1)
    {
        var A =points[i]
        val B =points[i-1]
        while (!A.contentEquals(B))
        {
            if(A[0]<B[0])
            {
                // go Diagonal vertical up
                A = intArrayOf(A[0]+1,A[1]+1)
                timeBackward++

            }else if(A[0]>B[0])
            {
                // go Diagonal vertical down
                A = intArrayOf(A[0]-1,A[1]-1)
                timeBackward++
            }else
            {
                // in case of x value are equal
                if(A[1]<B[1])
                {
                    //go straight horizontal to right
                    A = intArrayOf(A[0],A[1]+1)
                    timeBackward++

                }else if(A[1]>B[1])
                {
                    //go straight horizontal to left
                    A = intArrayOf(A[0],A[1]-1)
                    timeBackward++
                }

            }
        }

    }


    return min(timeBackward,timeForward)
}