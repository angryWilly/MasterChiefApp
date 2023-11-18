package com.example.abobusteam

data class RecipeListItem(
    var id: Int,
    var title: String,
    var image: String
)

data class RecipeResponse(
    var results: List<RecipeListItem>,
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

data class Recipe(
    var id: Int,
    var title: String,
    var image: String,
    var summary: String,
    var instructions: String,
    var analyzedInstructions: List<RecipeAnalyzedInstruction> // length == 1
)

enum class Diet(val value: String) {
    Default(""),
    Vegetarian("vegetarian"),
    Vegan("vegan"),
    GlutenFree("gluten free")
}