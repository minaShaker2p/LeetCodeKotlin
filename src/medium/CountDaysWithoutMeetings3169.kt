package medium

object CountDaysWithoutMeetings3169 {
    fun countDays(days: Int, meetings: Array<IntArray>): Int {
        var freeDays = 0
        var latestEnd = 0

        // Sort meetings based on starting times
        meetings.sortBy { it[0] }

        for (meeting in meetings) {
            val start = meeting[0]
            val end = meeting[1]

            // Add current range of days without meeting
            if (start > latestEnd + 1) {
                freeDays += start - latestEnd - 1
            }

            // Update latest meeting end
            latestEnd = Math.max(latestEnd, end)
        }

        // Add all days after the last day of meetings
        freeDays += days - latestEnd

        return freeDays
    }
}