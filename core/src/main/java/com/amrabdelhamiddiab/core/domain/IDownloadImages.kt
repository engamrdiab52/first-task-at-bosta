package com.amrabdelhamiddiab.core.domain

import com.amrabdelhamiddiab.core.data.PhotoThum

interface IDownloadImages {
    suspend fun downloadImages(albumId: Long): List<PhotoThum>?
}