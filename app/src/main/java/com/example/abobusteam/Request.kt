package com.example.abobusteam

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.io.IOException
import kotlin.math.roundToInt
import okhttp3.Response as ResponseOkHTTP

class APIKeyProvider : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): ResponseOkHTTP {
        val builder = chain.request().newBuilder()
        builder.addHeader("x-api-key", "0f42cff862b4415eada3c2bbf03335c7")
        return chain.proceed(builder.build())
    }
}

interface SpoonacularAPI {
    @GET("recipes/complexSearch")
    suspend fun getRecipes(@Query("offset") offset: Int = 0,
                           @Query("query") query: String = "",
                           @Query("diet") diet: Recipe.Diet = Recipe.Diet.Default,
                           @Query("maxReadyTime") maxReadyTime: Int = 20,
                           @Query("minCalories") minCalories: Int = 0,
                           @Query("maxCalories") maxCalories: Int = 9999,
                           @Query("number") number: Int = 10,
                           @Query("type") type: Recipe.Type = Recipe.Type.Default) : RecipeListResponse

    @GET("recipes/{id}/information")
    suspend fun getRecipe(@Path(value = "id", encoded = true) id: Int) : RecipeResponse

    @GET("recipes/findByIngredients")
    suspend fun getRecipesByIngredients(@Query("ingredients") ingredients: String = "",
                                        @Query("number") number: Int = 3) : List<RecipeListItem>
}

class Request {
    private val client = OkHttpClient.Builder().addNetworkInterceptor(APIKeyProvider()).build()
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.spoonacular.com")
        .client(client)
        .build()
        .create(SpoonacularAPI::class.java)

    suspend fun getRecipes(offset: Int = 0,
                           query: String = "",
                           diet : Recipe.Diet = Recipe.Diet.Default,
                           maxReadyTime: Int = 20,
                           minCalories: Int = 0,
                           maxCalories: Int = 9999,
                           type: Recipe.Type = Recipe.Type.Default,
                           count: Int = 10): List<RecipeListItem>
    {
        return retrofit.getRecipes(offset, query, diet, maxReadyTime, minCalories, maxCalories, count, type).results
    }

    suspend fun getRecipe(id: Int = 0) : Recipe {
        val response = retrofit.getRecipe(id)
        val ingredients : MutableList<RecipeIngredient> = mutableListOf()

        response.extendedIngredients.forEach {
            ingredients.add(RecipeIngredient(it.name, it.measures.metric.amount, it.measures.metric.unitShort))
        }

        return Recipe(
            response.id,
            response.title,
            response.image,
            response.summary,
            response.readyInMinutes,
            (response.pricePerServing / 100).roundToInt(),
            response.instructions,
            response.analyzedInstructions.getOrNull(0)?.steps,
            ingredients,
        );
    }

    suspend fun getRecipesByIngredients(ingredients: String = "", number: Int = 3) : List<RecipeListItem> {
        return retrofit.getRecipesByIngredients(ingredients, number)
    }
}