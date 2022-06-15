package com.amrabdelhamiddiab.firsttaskatbosta.presentation.albumsScreen

import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.TypedEpoxyController
import com.amrabdelhamiddiab.core.data.Album
import com.amrabdelhamiddiab.firsttaskatbosta.albumNameCard
import javax.inject.Inject

class AlbumsEpoxyController (private val albumsViewModel: AlbumsViewModel) :
    TypedEpoxyController<List<Album>>(
        EpoxyAsyncUtil.getAsyncBackgroundHandler(),
        EpoxyAsyncUtil.getAsyncBackgroundHandler()
    ) {
    override fun buildModels(data: List<Album>?) {
        data?.forEachIndexed { _, album ->
            albumNameCard {
                id(album.id)
                album(album)
                onClickContent {
                    _-> this@AlbumsEpoxyController.albumsViewModel.buttonClicked(album.id)

                }
            }


        }
    }
}