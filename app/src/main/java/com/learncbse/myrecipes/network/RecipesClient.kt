package com.learncbse.myrecipes.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.learncbse.myrecipes.utils.RECIPES_BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()


val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(RECIPES_BASE_URL)
    .build()

object RecipesClient {
    val allRecipes: RecipeApi by lazy {
        retrofit.create(RecipeApi::class.java)
    }
}

