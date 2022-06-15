package com.amrabdelhamiddiab.firsttaskatbosta.framework.cloud

import android.util.Log
import com.amrabdelhamiddiab.core.data.PhotoThum
import com.amrabdelhamiddiab.core.domain.IDownloadImages
import com.amrabdelhamiddiab.firsttaskatbosta.MainActivity
import com.amrabdelhamiddiab.firsttaskatbosta.framework.api.BostaService
import java.lang.Exception
import javax.inject.Inject

class DownloadPhotosImpl @Inject constructor(private val bostaService: BostaService): IDownloadImages {
    override suspend fun downloadImages(albumId: Long): List<PhotoThum>? {
        return try {
            bostaService.fetchImagesOfOneAlbum(albumId)
        } catch (e: Exception) {
            Log.d(MainActivity.TAG, e.message.toString())
            emptyList()
        }
    }
}