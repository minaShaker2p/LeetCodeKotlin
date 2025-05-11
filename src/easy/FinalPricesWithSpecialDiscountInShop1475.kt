package easy

object FinalPricesWithSpecialDiscountInShop1475 {
    fun finalPrices(prices: IntArray): IntArray {

        for (i in 0 until prices.size - 1) {
            for (j in i + 1 until prices.size) {
                if (prices[j] <= prices[i]) {
                    prices[i] = prices[i] - prices[j]
                    break
                }
            }
        }
        return prices
    }
}