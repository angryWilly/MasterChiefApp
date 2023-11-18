# Инструкции для запросов к API
## Создание сервиса

```kotlin
val service = Request.createService()
```

## Поиск рецептов

```kotlin
// offset = 0, query = pasta, diet = GlutenFree
val recipeListCall = service.getRecipes(0, "pasta", Diet.GlutenFree)

// вывод ответа в лог
recipeListCall.enqueue( object : Callback<RecipeResponse> {
    override fun onResponse(call: Call<RecipeResponse>, response: Response<RecipeResponse>) {
        Log.e("request:log", response.body()?.number.toString())
    }
    override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
        Log.e("request:log", t.toString())
    }
})
```

## Получение детальной информации о рецепте

```kotlin
// id = 782585
val recipeCall = service.getRecipe(782585)

recipeCall.enqueue( object : Callback<Recipe> {
    override fun onResponse(call: Call<Recipe>, response: Response<Recipe>) {
        // чем больше знаков, тем лучше
        Log.e("request:log", response.body()?.analyzedInstructions?.get(0)?.steps.toString())
    }
    
    override fun onFailure(call: Call<Recipe>, t: Throwable) {
        Log.e("request:log", t.toString())
    }
})
```

