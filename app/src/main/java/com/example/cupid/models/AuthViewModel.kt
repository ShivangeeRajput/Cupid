package com.example.cupid.models

import android.service.autofill.UserData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cupid.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _userData = MutableLiveData<UserData>()
    val userData: LiveData<UserData> get() = _userData

    fun setUserData(userData: UserData) {
        _userData.value = userData
    }

    fun updateUserData(firstName: String? = null, lastName: String? = null, email: String? = null) {
        val currentData = _userData.value ?: UserData()
        _userData.value = currentData.copy(
            firstName = firstName ?: currentData.firstName,
            lastName = lastName ?: currentData.lastName,
            email = email ?: currentData.email
        )
    }

    fun registerUser() {
        _userData.value?.let {
            viewModelScope.launch {
                userRepository.registerUser(it)

            }
        }
    }

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            userRepository.loginUser(email, password)

        }
    }
}
