package com.amrabdelhamiddiab.core.domain

class RepositoryUser (private val iDownloadUser: IDownloadUser) {
    suspend fun downloadUser(userId:Long) = iDownloadUser.downloadUser(userId)
}
