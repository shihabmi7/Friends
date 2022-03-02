package com.shihab.friends.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shihab.friends.model.UserResponse
import com.shihab.friends.repository.UserRepository
import com.shihab.friends.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    private val _userList : MutableLiveData<NetworkResult<UserResponse>> = MutableLiveData()
    val userList: LiveData<NetworkResult<UserResponse>> = _userList

    fun getUserListWithFlow() {
        viewModelScope.launch {
            repository.getAllUserWithFlow("json", 10).collect { values ->
                _userList.value = values
            }
        }
    }
}