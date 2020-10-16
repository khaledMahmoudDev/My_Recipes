package com.learncbse.myrecipes.datamodel

// data model for network
data class NetworkRecipeModel(
    val id: String = "",
    val calories: String = "",
    val carbos: String = "",
    val description: String = "",
    val difficulty: Int = 0,
    val fats: String = "",
    val headline: String = "",
    val image: String = "",
    val name: String = "",
    val proteins: String = "",
    val thumb: String = "",
    val time: String = ""
)


// convert Network model to default RecipeModel
fun List<NetworkRecipeModel>.asRecipeModel(): List<RecipeModel> {
    return map {
        RecipeModel(
            id = it.id,
            calories = it.calories,
            carbos = it.carbos,
            description = it.description,
            difficulty = it.difficulty,
            fats = it.fats,
            headline = it.headline,
            image = it.image,
            name = it.name,
            proteins = it.proteins,
            thumb = it.thumb,
            time = it.time
        )
    }
}


// convert Network model to default DatabaseModel
fun List<NetworkRecipeModel>.asDataBaseRecipeModel(): Array<DataBaseRecipeModel> {
    return map {
        DataBaseRecipeModel(
            id = it.id,
            calories = it.calories,
            carbos = it.carbos,
            description = it.description,
            difficulty = it.difficulty,
            fats = it.fats,
            headline = it.headline,
            image = it.image,
            name = it.name,
            proteins = it.proteins,
            thumb = it.thumb,
            time = it.time
        )
    }.toTypedArray()
}