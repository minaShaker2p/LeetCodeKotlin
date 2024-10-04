package medium

object DividePlayersIntoTeamsOfEqualSkill2491 {
    fun dividePlayers(skill: IntArray): Long {
        // Soring the array
        skill.sort()

        val n = skill.size
        var totalChemistry = 0L

        // Calculate the target sum
        val targetTeamSkill = skill[0] + skill[n-1]

        // Iterate through half of the array, pairing players from both ends
        for(i in 0 until n/2)
        {
            val currentTeamSkill =  skill[i]+ skill[n-i-1]

            if(currentTeamSkill != targetTeamSkill)
                return -1

            totalChemistry+=skill[i]* skill[n-i-1]
        }

        return totalChemistry



    }
}