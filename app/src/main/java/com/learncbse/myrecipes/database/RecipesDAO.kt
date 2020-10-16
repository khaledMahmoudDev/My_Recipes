package com.learncbse.myrecipes.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.learncbse.myrecipes.datamodel.DataBaseRecipeModel


// main DAO for the ROOM Database
@Dao
interface RecipesDAO {

    // fun to insert any number of recipes
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllRecipes(vararg recipes: DataBaseRecipeModel)

    // fun get all recipes from database
    @Query(value = "SELECT * FROM recipes_table")
    fun getAllRecipes(): LiveData<List<DataBaseRecipeModel>>

}