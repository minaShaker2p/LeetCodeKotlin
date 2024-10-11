package medium

object TheNumberOfTheSmallestUnoccupiedChair1942 {
    fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
        val timesAndFriends = HashMap<IntArray, Int>()

        times.forEachIndexed { index, time ->
            timesAndFriends[time] = index
        }

        // Sort the times array based on the arrival time
        val sortedTimes = times.sortedBy { arr: IntArray -> arr[0] }

        val occupiedChairs = IntArray(times.size) { -1 }


        for(i in sortedTimes.indices)
        {
            val friend = timesAndFriends.getOrDefault(sortedTimes[i],0)
            occupiedChairs[friend]=i
        }
        return occupiedChairs[targetFriend]
    }
}