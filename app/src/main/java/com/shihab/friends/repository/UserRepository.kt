package com.shihab.friends.repository

import com.shihab.friends.model.BaseApiResponse
import com.shihab.friends.model.User
import com.shihab.friends.model.UserResponse
import com.shihab.friends.network.UserInterface
import com.shihab.friends.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class UserRepository @Inject constructor(private val userInterface: UserInterface) :
    BaseApiResponse() {

    suspend fun getAllUser(format: String, range: Int): List<User>? {
        val userResponse = userInterface.getUserList(format, range)
        return userResponse.results
    }

    fun getAllUserWithFlow(format: String, range: Int): Flow<NetworkResult<UserResponse>> {
        return flow {
            val fooList = safeApiCall { userInterface.getUserListWithFlow(format, range) }
            emit(fooList)
        }.flowOn(Dispatchers.IO)
    }

}