package medium

import java.util.LinkedList
import java.util.Queue

object FindAllPossibleRecipesFromGivenSupplies2115 {
    fun findAllRecipes(
        recipes: Array<String>,
        ingredients: List<List<String>>,
        supplies: Array<String>
    ): List<String> {
        // Track available ingredients and recipes
        val available = mutableSetOf<String>()
        available.addAll(supplies)

        // Queue to process recipe indices
        val recipesQueue: Queue<Int> = LinkedList<Int>()
        for (i in recipes.indices)
            recipesQueue.add(i)

        val createdRecipes = mutableListOf<String>()
        var lastSize = -1
        // Continue while we keep finding new recipes
        while (available.size > lastSize) {
            lastSize = available.size
            var queueSize = recipesQueue.size

            // Process all recipes in current queue
            while (queueSize-- > 0) {
                val recipeIndex = recipesQueue.poll()

                // Check if all ingredients are available
                val hasAllIngredients = ingredients[recipeIndex].all { available.contains(it) }
                if (hasAllIngredients) {
                    available.add(recipes[recipeIndex])
                    createdRecipes.add(recipes[recipeIndex])
                } else {
                    recipesQueue.add(recipeIndex)
                }
            }
        }

        return createdRecipes
    }
}