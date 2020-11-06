package easy

/*
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example 1:

Input: a = 1, b = 2
Output: 3
 */

fun getSum(a: Int, b: Int): Int {
    return a.plus(b);
}

fun getSum2(a: Int, b: Int): Int {
    var ans = 0
    var sum = 0
    var carry = 0
    for (i in 0..31) {
        sum = gb(a, i) xor gb(b, i) xor carry //sum is Xor of ith bit of a,b and carry;
        carry = carry and gb(a, i) or (gb(a, i) and gb(b, i)) or (gb(b, i) and carry)
        // carry is 1 when any of the two bits is 1 out of the three which are ith bit of a or b or previous carry
        if (sum == 1) ans = sb(ans, i)
    }
    return ans
}

fun gb(x: Int, y: Int): Int { //getbit  function to get ith bit
    return if (x and (1 shl y) == 0) 0 else 1
}

fun sb(x: Int, y: Int): Int { //setbit function to set ith bit
    return x or (1 shl y)
}