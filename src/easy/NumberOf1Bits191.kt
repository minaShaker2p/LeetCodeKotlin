package easy

fun hammingWeight(n:Int):Int {

    var count = 0
    n.toString().forEach{
        if(it == '1')
            ++count
    }
    return count
}