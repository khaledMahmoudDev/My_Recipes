package com.learncbse.myrecipes.datamodel


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