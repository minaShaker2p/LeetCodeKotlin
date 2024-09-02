
package medium

// Brute Force approach
// Time complexity is O(N2)
fun chalkReplacer(chalk: IntArray, k: Int): Int {
    var chalks = k

    while(true)
    {
        for(i in chalk.indices)
        {
            if(chalk[i]<=chalks)
            {
                chalks-=chalk[i]
            }else
            {
                return i
            }
        }
    }
}

// Using Prefix Sum
// Time complexity is O(N)
fun chalkReplacerSolution2(chalk: IntArray, k: Int): Int {
    // Find the sum of all elements
    var sum =0L
    for(i in chalk.indices)
    {
        sum+=chalk[i]
    }

    // Find modulo of k with sum
    var rem = k % sum

    for( i in chalk.indices)
    {
        if(chalk[i] > rem)
            return i
        rem -= chalk[i]
    }

    return 0

}