package medium

object DividePlayersIntoTeamsOfEqualSkill2491 {
    fun dividePlayers(skill: IntArray): Long {
        val min = skill.min()
        val max = skill.max()

        val map = HashMap<Int, Int>()

        skill.forEach { num ->
            val rem = (max + min) - num
            if(map.contains(rem).not())
            map[num] =  rem
        }

        var chemistry = 0L
        for((k,v) in map)
        {
            chemistry+=(k * v)
        }
        return chemistry/2

    }
}