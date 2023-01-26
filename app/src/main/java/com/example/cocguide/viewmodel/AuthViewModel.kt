package com.example.cocguide.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocguide.model.AuthRepository
import com.example.cocguide.model.network.Resource
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel (
    private val repository : AuthRepository
        ) : ViewModel() {


//    private var username: String? = null
//    private var password : String? = null

    private val _loginFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val loginFLow : StateFlow<Resource<FirebaseUser>?> = _loginFlow

    private val _signupFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val signupFlow : StateFlow<Resource<FirebaseUser>?> = _signupFlow

    val currentUser : FirebaseUser?
    get() = repository.currentUser

    init {
        if(repository.currentUser != null)
        {
            _loginFlow.value = Resource.success(repository.currentUser!!)
        }
    }

    fun login(email: String?, password: String?) = viewModelScope.launch {
        _loginFlow.value = Resource.loading(null)
        val result = repository.login(email = email!!, password = password!!)
        _loginFlow.value = result
    }

    fun signup(name : String?, email: String?, password: String?) = viewModelScope.launch {
        _signupFlow.value = Resource.loading(null)
        val result = repository.signup(username = name!!, email = email!!, password = password!!)
        _signupFlow.value = result
    }

    fun logout(){
        repository.logout()
        _loginFlow.value = null
        _signupFlow.value = null
    }


    fun authenticateUser(username : String?, password : String?)
    {

    }
}