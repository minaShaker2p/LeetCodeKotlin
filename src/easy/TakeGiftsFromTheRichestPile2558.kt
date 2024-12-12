package easy

object TakeGiftsFromTheRichestPile2558 {
    fun pickGifts(gifts: IntArray, k: Int): Long {

        (1..k).forEach {
            // Find the maximum pile of gifts
            var maxPile = Int.MIN_VALUE
            var maxPileIndex = -1
            for (i in gifts.indices) {
                if (gifts[i] > maxPile) {
                    maxPile = gifts[i]
                    maxPileIndex = i
                }
            }
            val maxPileSquareRoot = Math.sqrt(gifts[maxPileIndex].toDouble()).toInt()
            gifts[maxPileIndex] = maxPileSquareRoot
        }
        var sum = 0L
        gifts.forEach { sum+=it }
        return sum
    }
}