package com.example.abobusteam

data class RecipeListItemIml(
    var id: Int,
    var title: String,
    var image: String,
    var pricePerServing: Float,
)

data class RecipeListItem(
    var id: Int,
    var title: String,
    var image: String,
    var pricePerServing: Int,
)

data class RecipeListResponse(
    var results: MutableList<RecipeListItemIml>,
    var offset: Int,
    var number: Int,
    var totalResults: Int
)

data class RecipeStepIngredient(
    val id: Int,
    val name: String
)

data class RecipeStepEquipment(
    val id: Int,
    val name: String
)

data class RecipeStepLength(
    val number: Int,
    var unit: String,
)

data class RecipeInstructionStep(
    var step: String,
    var length: RecipeStepLength,
    var ingredients: List<RecipeStepIngredient>,
    var equipment: List<RecipeStepEquipment>
)

data class RecipeAnalyzedInstruction(
    var steps: List<RecipeInstructionStep>
)

data class Measures(
    var amount: Float,
    var unitShort: String
)

data class RecipeExtendedIngredientMeasures(
    var metric: Measures,
    var us: Measures
)

data class RecipeExtendedIngredientsResponse(
    var measures: RecipeExtendedIngredientMeasures,
    var name: String,
)

data class RecipeResponseNutrients(
    var name: String,
    var amount: Float,
)

data class RecipeResponseNutrition(
    var nutrients: List<RecipeResponseNutrients>
)

data class RecipeResponse(
    var id: Int,
    var title: String,
    var image: String,
    var summary: String,
    var instructions: String,
    var readyInMinutes: Int,
    var servings: Int,
    var pricePerServing: Float,
    var analyzedInstructions: List<RecipeAnalyzedInstruction>, // length == 1
    var extendedIngredients: List<RecipeExtendedIngredientsResponse>,
    var nutrition: RecipeResponseNutrition
)

data class RecipeIngredient(
    var name: String,
    var amount: Float,
    var unit: String,
)

data class RecipeNutrients(
    var calories: Int? = null,
    var fat: Int? = null,              // жиры
    var carbohydrates: Int? = null,    // углеводы
    var protein: Int? = null           // белки
)

data class Recipe(
    var id: Int,
    var title: String,
    var image: String,
    var summary: String,
    var readyInMinutes: Int,
    var pricePerServing: Int,
    var instructions: String?,
    var steps: List<RecipeInstructionStep>?,
    var ingredients: List<RecipeIngredient>?,
    var nutrients: RecipeNutrients
) {
    enum class Diet(val value: String) {
        Default(""),
        Vegetarian("vegetarian"),
        Vegan("vegan"),
        GlutenFree("gluten free")
    }

    enum class Type(val value: String) {
        Default(""),
        MainCourse("main course"),
        SideDish("side dish"),
        Dessert("dessert"),
        Salad("salad"),
        Breakfast("breakfast"),
        Lunch("lunch"),
        Dinner("dinner"),
        Snack("snack"),
        Marinade("marinade"),
        Drink("drink"),
        Soup("soup"),
        Beverage("beverage")
    }
}

