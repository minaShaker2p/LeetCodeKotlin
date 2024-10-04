package medium

object DividePlayersIntoTeamsOfEqualSkill2491 {
    /**
     * TIME COMPLEXITY O(N.LOG(N))
     */
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

    /**
     * TIME COMPLEXITY O(N)
     */
    fun dividePlayersSolution2(skill: IntArray): Long {
        val n = skill.size
        var totalSkill = 0
        val skillFrequency =  IntArray(1001)

        // Calculate total skill and skill frequency
        for( playerSkill in skill)
        {
            totalSkill += playerSkill
            skillFrequency[playerSkill]++
        }

        // Check if total skill can be evenly distributed among teams
        if(totalSkill % (n/2) !=0) return -1

        val targetTeamSkill = totalSkill/ (n/2)
        var totalChemistry = 0L

        // Calculate total chemistry while verifying valid team formations
        for(playerSkill in skill)
        {
            val partnerSkill = targetTeamSkill - playerSkill

            // Check if a valid partner exists
            if(skillFrequency[partnerSkill]==0) return -1

            totalChemistry += playerSkill * partnerSkill
            skillFrequency[partnerSkill]--
        }

        return totalChemistry/2
    }
}