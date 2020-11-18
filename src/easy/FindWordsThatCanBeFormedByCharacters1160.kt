package easy

fun countCharacters(words: Array<String>, chars: String): Int {

    if(words.isEmpty() ||chars.length >100 || words.size > 1000)
        return 0

    var length= 0
    words.forEach {word ->
        if(word.isFormedBy(chars))
            length+=word.length
    }
    return length
}


fun String.isFormedBy(chars:String) :Boolean
{
    if(this.isEmpty())
        return false

    this.forEach{ char ->
        if(!chars.contains(char))
            return false
    }

    return true
}