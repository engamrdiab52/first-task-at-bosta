package com.amrabdelhamiddiab.core.domain

import com.amrabdelhamiddiab.core.data.User

interface IDownloadUser {
    suspend fun downloadUser(userId: Long):List<User> ?
}