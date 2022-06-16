package com.amrabdelhamiddiab.firsttaskatbosta.framework.cloud

import android.util.Log
import com.amrabdelhamiddiab.core.data.User
import com.amrabdelhamiddiab.core.domain.IDownloadUser
import com.amrabdelhamiddiab.firsttaskatbosta.MainActivity
import com.amrabdelhamiddiab.firsttaskatbosta.framework.api.BostaService
import java.lang.Exception
import javax.inject.Inject

class DownloadUserImpl @Inject constructor(private val bostaService: BostaService):IDownloadUser {
    override suspend fun downloadUser(userId: Long): List<User>? {
        return try {
            val listOfUsers :List<User>?
            bostaService.fetchSingleUser(userId)
        } catch (e: Exception) {
            Log.d(MainActivity.TAG, e.message.toString())
            null
        }
    }
}