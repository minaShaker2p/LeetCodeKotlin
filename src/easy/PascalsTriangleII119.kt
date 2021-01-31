package easy

/*
Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.

Notice that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Follow up:

Could you optimize your algorithm to use only O(k) extra space?
Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]
 */
fun getRow(rowIndex: Int): List<Int> {
    val result= mutableListOf<MutableList<Int>>()
    for(i in 0 .. rowIndex)
    {
        result.add(i, mutableListOf())
        for(j in 0 .. i)
        {
            if(j==0 || j==i)
                result[i].add(j,1)
            else
            {
                val temp= result[i-1][j-1]+result[i-1][j]
                result[i].add(j,temp)

            }
        }
    }
    return result[rowIndex]
}