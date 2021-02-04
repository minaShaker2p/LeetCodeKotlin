package easy

import kotlin.math.min

/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
Example 3:

Input: height = [4,3,2,1,4]
Output: 16
Example 4:

Input: height = [1,2,1]
Output: 2
 */
fun maxArea(height: IntArray): Int {
    var maxArea=0
    for(i in height.indices)
    {
        for( j in i+1 until height.size)
        {
            maxArea=Math.max(maxArea,((j-i)* Math.min(height[i],height[j])))
        }
    }
return maxArea
}
fun maxAreaSolution2(height: IntArray):Int{
    var maxArea=Int.MIN_VALUE
    var i =0
    var j=height.size-1
    while (i<j)
    {
        val min =Math.min(height[i],height[j])
        maxArea=Math.max(maxArea,(j-i)*min)
        if(height[i]<height[j])
            i++
        else
            j--
    }
    return maxArea
}