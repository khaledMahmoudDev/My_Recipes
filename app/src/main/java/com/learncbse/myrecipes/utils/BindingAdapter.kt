package com.learncbse.myrecipes.utils

import android.widget.ImageView
import android.widget.RatingBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.learncbse.myrecipes.adapter.RecipesListAdapter
import com.learncbse.myrecipes.datamodel.RecipeModel

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        Glide.with(imgView.context)
            .load(imgUrl)
            .into(imgView)
    }
}


@BindingAdapter("recipeBindListAdapterData", "recipeBindListAdapterFilter")
fun recipesBindListAdapter(recyclerView: RecyclerView, data: List<RecipeModel>?, filter: String) {
    val adapter = recyclerView.adapter as RecipesListAdapter

    val result = if (filter.isNotEmpty()) {
        data?.filter { it.name.toLowerCase().contains(filter.toLowerCase()) }
    } else {
        data
    }
    adapter.submitList(result)

}

@BindingAdapter("difficultyAdapter")
fun difficultyBindAdapter(ratingBar: RatingBar, data: Int) {
    ratingBar.rating = data.toFloat()
}