
package medium

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