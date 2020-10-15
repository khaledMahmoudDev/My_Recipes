package com.learncbse.myrecipes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.learncbse.myrecipes.datamodel.DataBaseRecipeModel

@Database(entities = [DataBaseRecipeModel::class], version = 1, exportSchema = false)
abstract class RecipesDataBase : RoomDatabase() {
    abstract val recipesDAO: RecipesDAO

    companion object {

        @Volatile
        private var INSTANCE: RecipesDataBase? = null


        fun getInstance(context: Context): RecipesDataBase {
            synchronized(lock = this)
            {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext, RecipesDataBase::class.java,
                        "recipes"
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance

                }
                return instance
            }
        }
    }

}