package com.example.mvvmwithdagger.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class PeopleBindingAdapter {
    companion object {
        @BindingAdapter("loadPeopleImage")
        @JvmStatic
        fun loadPeopleImage(imageView: ImageView, imageUrl: String) {
            Glide.with(imageView.context)
                .asBitmap()
                .load(imageUrl)
                .into(imageView)
        }
    }
}