package com.shihab.friends.network

import com.shihab.friends.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserInterface {
    @GET("api/")
    suspend fun getUserList(
        @Query("format") format: String,
        @Query("results") results: Int
    ): UserResponse

    @GET("api/")
    suspend fun getUserListWithFlow(
        @Query("format") format: String,
        @Query("results") results: Int
    ): Response<UserResponse>
}