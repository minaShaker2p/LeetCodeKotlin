package medium

import java.util.TreeMap

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

// Using Line Sweep Algorithm
class MyCalendarTwoSol2 {
    private val bookingCount = TreeMap<Int, Int>()
    private val maxOverlappedBooking = 2

    fun book(start: Int, end: Int): Boolean {
        // Increase the booking count at 'start' and decrease at 'end'
        bookingCount[start] = bookingCount.getOrDefault(start, 0) + 1
        bookingCount[end] = bookingCount.getOrDefault(end, 0) - 1

        var overlappedBooking = 0

        // Calculate the prefixSum of bookings
        for ((key, value) in bookingCount) {
            overlappedBooking += value

            // If the number of overlaps exceeds the allowed limit, rollback and return false
            if (overlappedBooking > maxOverlappedBooking) {
                // Rollback changes
                bookingCount[start] = bookingCount.getOrDefault(start, 0) - 1
                bookingCount[end] = bookingCount.getOrDefault(end, 0) + 1

                // Clean up if the count becomes zero to maintain the map clean
                if (bookingCount[start] == 0) {
                    bookingCount.remove(start)
                }
                return false
            }
        }
        return true
    }
}