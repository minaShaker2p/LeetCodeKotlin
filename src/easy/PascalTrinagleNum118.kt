package easy

fun generate(numRows: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>();
    for (i in 0 until numRows) {
        val row = mutableListOf<Int>();
        for (j in 0 .. i) {
            if(j==0 || j==i)
            row.add(j, 1);
            else
            {
                val previous= result[i-1];
                val sum =previous[j-1]+previous[j];
                row.add(j, sum);
            }
        }
        result.add(i, row);
    }
    return result;
}