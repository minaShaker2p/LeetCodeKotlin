package medium

class MyCalendarTwo {
    private val bookings = mutableListOf<IntArray>()
    private val overlapBookings = mutableListOf<IntArray>()

    // Return true if the booking [start1,end1] & [start2,end2] overlaps
    private fun doesOverlap(start1: Int, end1: Int, start2: Int, end2: Int): Boolean {
        return start1.coerceAtLeast(start2) < end1.coerceAtMost(end2)
    }

    // Return overlapping booking between [start1,end1] & [start2,end2]
    private fun getOverlappedInterval(start1: Int, end1: Int, start2: Int, end2: Int): IntArray {
        return intArrayOf(start1.coerceAtLeast(start2), end1.coerceAtMost(end2))
    }

    fun book(start: Int, end: Int): Boolean {
        // Return false if the new booking has an overlap
        // with the excising double-booked bookings

        for (booking in overlapBookings) {
            if (doesOverlap(booking[0], booking[1], start, end))
                return false
        }

        // Add the double overlapping bookings if any with the new booking
        for (booking in bookings) {
            if (doesOverlap(booking[0], booking[1], start, end))
                overlapBookings.add(getOverlappedInterval(booking[0], booking[1], start, end))
        }

        // Add the new booking to the list of the bookings
        bookings.add(intArrayOf(start, end))
        return true
    }
}