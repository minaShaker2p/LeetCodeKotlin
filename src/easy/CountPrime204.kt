package easy

import kotlin.math.pow

fun countPrimes(n: Int): Int {

    var count = 0
    val list = mutableListOf(2, 3, 5, 7)

        for (i in 2 until n) {
            if (i.isPrime(list))
                count++
        }
    return count
}

fun Int.isPrime(list: MutableList<Int>): Boolean {
    list.forEach {
        if (this == it)
            return true
        if (this % it == 0)
            return false
    }
    list.add(this)
    return true
}