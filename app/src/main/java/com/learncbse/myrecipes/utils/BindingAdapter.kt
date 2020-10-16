package com.learncbse.myrecipes.utils

import android.widget.ImageView
import android.widget.RatingBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.learncbse.myrecipes.adapter.RecipesListAdapter
import com.learncbse.myrecipes.datamodel.RecipeModel


// main binding adapter


//bind images
@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        Glide.with(imgView.context)
            .load(imgUrl)
            .into(imgView)
    }
}

//bind recyclerView
@BindingAdapter(
    "recipeBindListAdapterData",
    "recipeBindListAdapterFilter",
    "recipeBindListAdapterSort"
)
fun recipesBindListAdapter(
    recyclerView: RecyclerView,
    data: List<RecipeModel>?,
    filter: String,
    sortNum: Int
) {
    val adapter = recyclerView.adapter as RecipesListAdapter

    var result = if (filter.isNotEmpty()) {
        data?.filter { it.name.toLowerCase().contains(filter.toLowerCase()) }
    } else {
        data
    }

    val sortResult = when (sortNum) {
        0 -> {
            result
        }
        1 -> {
            result?.sortedBy { recipeModel ->
                var fats = getNumericValueFromString(recipeModel.fats)
                fats
            }
        }
        2 -> {
            result?.sortedByDescending { recipeModel ->
                var fats = getNumericValueFromString(recipeModel.fats)
                fats
            }
        }
        3 -> {
            result?.sortedBy { recipeModel ->
                var calories = getNumericValueFromString(recipeModel.calories)
                calories
            }
        }
        4 -> {
            result?.sortedByDescending { recipeModel ->
                var calories = getNumericValueFromString(recipeModel.calories)
                calories
            }
        }
        else -> {
            result
        }
    }
    adapter.submitList(sortResult)

}


//bind ratingBar
@BindingAdapter("difficultyAdapter")
fun difficultyBindAdapter(ratingBar: RatingBar, data: Int) {
    ratingBar.rating = data.toFloat()
}