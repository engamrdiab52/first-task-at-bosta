package com.amrabdelhamiddiab.core.usecases

import com.amrabdelhamiddiab.core.domain.RepositoryUser

class DownloadUser (private val repositoryUser: RepositoryUser) {
    suspend operator fun invoke(userId: Long) = repositoryUser.downloadUser(userId)
}