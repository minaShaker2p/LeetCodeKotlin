package medium

object CountDaysWithoutMeetings3169 {
    fun countDays(days: Int, meetings: Array<IntArray>): Int {
        val workingDays = IntArray(days)
        for (meeting in meetings) {
            (meeting[0]..meeting[1]).forEach { workingDays[it-1] = 1 }
        }
        var count =0
        workingDays.forEach {
            if(it==0)
                count++
        }

        return count
    }
}