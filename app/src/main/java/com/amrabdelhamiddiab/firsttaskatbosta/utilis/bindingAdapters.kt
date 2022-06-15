package com.amrabdelhamiddiab.firsttaskatbosta.utilis


import android.widget.ImageView
import androidx.databinding.BindingAdapter

import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders


@BindingAdapter("imageUrl")
fun bindImageUrl(view: ImageView, url: String?) {

    val rightImage = GlideUrl(url, LazyHeaders.Builder().addHeader("User-Agent","5").build())

    if (!url.isNullOrEmpty()) {
        Glide.with(view.context).load(rightImage).into(view)
    }
}
