package com.shihab.friends.utils

sealed class NetworkResult<T>(
    val status: Status,
    val data: T? = null,
    val message: String? = null,
) {

    class Success<T>(data: T) : NetworkResult<T>(Status.SUCCESS, data)

    class Error<T>(message: String, data: T? = null) : NetworkResult<T>(Status.ERROR, data, message)

    class Loading<T> : NetworkResult<T>(Status.LOADING)

}


enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}