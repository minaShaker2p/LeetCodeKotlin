package medium

object FindAllPossibleRecipesFromGivenSupplies2115 {
    fun findAllRecipes(
        recipes: Array<String>,
        ingredients: List<List<String>>,
        supplies: Array<String>
    ): List<String> {
        val ingredientsSet = mutableSetOf<String>()
        ingredientsSet.addAll(supplies)

        val result =  mutableListOf<String>()
        for (i in recipes.indices)
        {
            val recipeIngredients = ingredients[i]
            val hasAllIngredients =  recipeIngredients.all { ingredientsSet.contains(it) }
            if(hasAllIngredients)
            {
                result.add(recipes[i])
                ingredientsSet.add(recipes[i])
            }
        }
        return result
    }
}