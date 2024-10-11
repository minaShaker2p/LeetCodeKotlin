package medium

object TheNumberOfTheSmallestUnoccupiedChair1942 {
    fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
        val targetTime = times[targetFriend]

        // Sort the times array based on the arrival time
        val sortedTimes = times.sortedBy { arr: IntArray -> arr[0] }

        val n = times.size
        val chairTime = IntArray(n) { 0 }

        for (time in sortedTimes) {
            for (i in 0 until n) {
                if(chairTime[i]<=time[0])
                {
                    chairTime[i]=time[1]
                    if(time.contentEquals(targetTime))
                        return i
                    break
                }
            }
        }
        return 0
    }
}