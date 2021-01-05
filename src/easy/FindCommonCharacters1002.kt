package easy

import kotlin.math.min

/*
Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.
Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]
 */
fun commonChars(A: Array<String>): List<String> {
    val arr= Array(A.size){IntArray(26)}
    val result= arrayListOf<String>()
    for(i in A.indices)
    {
        A[i].forEachIndexed { index, c ->
            arr[i][c-'a']++
        }
    }
    for(i in 0 until 26)
    {
        var smallest=arr[0][i]
        for(j in 1 until arr.size)
        {
            smallest= Math.min(smallest,arr[j][i])
        }
        while (smallest-->0)
        {
            result.add(('a'+i).toString())
        }
    }

return result
}