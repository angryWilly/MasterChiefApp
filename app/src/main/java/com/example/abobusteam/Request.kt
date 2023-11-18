package com.example.abobusteam

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.io.IOException

class APIKeyProvider : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("x-api-key", "f6c7361a8152484fa8902c747b577387")
        return chain.proceed(builder.build())
    }
}

interface Request {
    @GET("recipes/complexSearch")
    fun getRecipes(@Query("offset") offset: Int = 0,
                   @Query("query") query: String = "",
                   @Query("diet") diet: Diet = Diet.Default) : Call<RecipeResponse>

    @GET("recipes/{id}/information")
    fun getRecipe(@Path(value = "id", encoded = true) id: Int) : Call<Recipe>

    companion object {
        private var BASE_URL = "https://api.spoonacular.com"

        fun createService() : Request {
            val client = OkHttpClient.Builder()
            client.addNetworkInterceptor(APIKeyProvider())

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(client.build())
                .build()
            return retrofit.create(Request::class.java)
        }
    }
}