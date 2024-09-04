package medium

import kotlin.math.sqrt

/**
 * A robot on an infinite XY-plane starts at point (0, 0) facing north. The robot can receive a sequence of these three possible types of commands:
 *
 * -2: Turn left 90 degrees.
 * -1: Turn right 90 degrees.
 * 1 <= k <= 9: Move forward k units, one unit at a time.
 * Some of the grid squares are obstacles. The ith obstacle is at grid point obstacles[i] = (xi, yi). If the robot runs into an obstacle, then it will instead stay in its current location and move on to the next command.
 *
 * Return the maximum Euclidean distance that the robot ever gets from the origin squared (i.e. if the distance is 5, return 25).
 *
 * Note:
 *
 * North means +Y direction.
 * East means +X direction.
 * South means -Y direction.
 * West means -X direction.
 * There can be obstacle in [0,0].
 *
 *
 * Example 1:
 *
 * Input: commands = [4,-1,3], obstacles = []
 * Output: 25
 * Explanation: The robot starts at (0, 0):
 * 1. Move north 4 units to (0, 4).
 * 2. Turn right.
 * 3. Move east 3 units to (3, 4).
 * The furthest point the robot ever gets from the origin is (3, 4), which squared is 32 + 42 = 25 units away.
 * Example 2:
 *
 * Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * Output: 65
 * Explanation: The robot starts at (0, 0):
 * 1. Move north 4 units to (0, 4).
 * 2. Turn right.
 * 3. Move east 1 unit and get blocked by the obstacle at (2, 4), robot is at (1, 4).
 * 4. Turn left.
 * 5. Move north 4 units to (1, 8).
 * The furthest point the robot ever gets from the origin is (1, 8), which squared is 12 + 82 = 65 units away.
 * Example 3:
 *
 * Input: commands = [6,-1,-1,6], obstacles = []
 * Output: 36
 * Explanation: The robot starts at (0, 0):
 * 1. Move north 6 units to (0, 6).
 * 2. Turn right.
 * 3. Turn right.
 * 4. Move south 6 units to (0, 0).
 * The furthest point the robot ever gets from the origin is (0, 6), which squared is 62 = 36 units away.
 */
object WalkingRobotSimulation874 {
    fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
        var maximumDistance = Int.MIN_VALUE

        var currentLocation = intArrayOf(0, 0)
        var currentDir = Dirs.NORTH

        commands.forEach { command ->

            if (command == -2) {
                // Turn left 90 degree
                currentDir = when (currentDir) {
                    Dirs.NORTH -> Dirs.WEST
                    Dirs.EAST -> Dirs.NORTH
                    Dirs.WEST -> Dirs.SOUTH
                    Dirs.SOUTH -> Dirs.EAST
                }
            } else if (command == -1) {
                // -1: Turn right 90 degrees
                currentDir = when (currentDir) {
                    Dirs.NORTH -> Dirs.EAST
                    Dirs.EAST -> Dirs.SOUTH
                    Dirs.SOUTH -> Dirs.WEST
                    Dirs.WEST -> Dirs.NORTH
                }
            } else {
                for (i in 0 until command) {
                    val nextStepLocation = currentLocation.copyOf()
                    when (currentDir) {
                        Dirs.NORTH -> {
                            // increase y by 1
                            nextStepLocation[1] = nextStepLocation[1] + 1
                            // check if it is obstacle
                        }

                        Dirs.EAST -> {
                            // increase x by 1
                            nextStepLocation[0] = nextStepLocation[0] + 1

                            // check if it is obstacle
                        }

                        Dirs.WEST -> {
                            // decrease x by 1
                            nextStepLocation[0] = nextStepLocation[0] - 1

                            // check if it is obstacle
                        }

                        Dirs.SOUTH -> {
                            // decrease y by 1
                            nextStepLocation[1] = nextStepLocation[1] - 1
                            // check if it is obstacle
                        }
                    }
                    if (obstacles.containObstacle(nextStepLocation).not()) {
                        currentLocation = nextStepLocation.clone()
                    } else {
                        break
                    }
                }
                maximumDistance = Math.max(maximumDistance,calculateEuclideanDistance(currentLocation))
            }
        }
        return maximumDistance
    }

    private fun Array<IntArray>.containObstacle(location: IntArray): Boolean {
        for (obstacle in this) {
            if (obstacle[0] == location[0] && obstacle[1] == location[1])
                return true
        }
        return false
    }
    private fun calculateEuclideanDistance(location:IntArray):Int{
        return (Math.pow(location[0].toDouble(), 2.0) + Math.pow(location[1].toDouble(), 2.0)).toInt()
    }

    enum class Dirs {
        NORTH, EAST, WEST, SOUTH
    }
}