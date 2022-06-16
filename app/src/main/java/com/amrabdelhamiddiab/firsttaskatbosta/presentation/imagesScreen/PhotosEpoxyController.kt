package com.amrabdelhamiddiab.firsttaskatbosta.presentation.imagesScreen

import android.util.Log
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.TypedEpoxyController
import com.amrabdelhamiddiab.core.data.Album
import com.amrabdelhamiddiab.core.data.PhotoThum
import com.amrabdelhamiddiab.firsttaskatbosta.MainActivity.Companion.TAG
import com.amrabdelhamiddiab.firsttaskatbosta.imageCard
import com.amrabdelhamiddiab.firsttaskatbosta.presentation.albumsScreen.AlbumsViewModel

class PhotosEpoxyController(private val albumsViewModel: AlbumsViewModel) :
    TypedEpoxyController<List<PhotoThum>>(
        EpoxyAsyncUtil.getAsyncBackgroundHandler(),
        EpoxyAsyncUtil.getAsyncBackgroundHandler()
    ) {
    override fun buildModels(data: List<PhotoThum>?) {
        data?.forEachIndexed { _, photo ->
            imageCard {
                id(photo.id)
                photo(photo)
                onClickContent {
                    _ -> this@PhotosEpoxyController.albumsViewModel.informImageClicked(photo)
                }
            }
        }
    }
}