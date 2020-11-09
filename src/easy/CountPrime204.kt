package easy

import kotlin.math.pow

fun countPrimes(n: Int): Int {

    // assume all number is prime from 0 until n
    val primes = BooleanArray(n)
    for (i in 0 until n) {
        primes[i] = true
    }
    var i = 2
    while ((i * i) < primes.size) {
        if (primes[i]) {
         var j = i
            while (i *j < primes.size)
            {
                primes[i*j]=false
                j++
            }
        }
        i++
    }
    var count = 0
    for(i in 2 until primes.size)
    {
        if(primes[i])
            count++
    }
    return count
}
