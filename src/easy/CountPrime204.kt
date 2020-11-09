package easy

fun countPrimes(n: Int): Int {

    var count = 0
    val list =mutableListOf<Int>()
    for( i in 1..n)
    {
        if(i.isPrime(list))
            count++
    }

    return count

}

fun Int.isPrime(list:MutableList<Int>):Boolean
{
    if(this <=1)
        return false
    else if(this == 2 || this == 3)
    {
        list.add(this)
        return true
    }
    else
    {
        list.forEach{
            if(this % it==0)
                return false
        }
        list.add(this)
        return true
    }

}