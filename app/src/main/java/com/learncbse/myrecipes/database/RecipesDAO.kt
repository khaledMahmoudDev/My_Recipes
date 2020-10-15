package com.learncbse.myrecipes.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.learncbse.myrecipes.datamodel.DataBaseRecipeModel

@Dao
interface RecipesDAO {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllRecipes(vararg recipes: DataBaseRecipeModel)


    @Query(value = "SELECT * FROM recipes_table")
    fun getAllRecipes(): LiveData<List<DataBaseRecipeModel>>

}