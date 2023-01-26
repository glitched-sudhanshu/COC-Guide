package com.example.cocguide.model

import com.example.cocguide.model.network.Resource
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import java.util.*

interface AuthRepository {

    val currentUser : FirebaseUser?
    suspend fun login(email : String, password : String) : Resource<FirebaseUser>
    suspend fun signup(username: String, email : String, password : String) : Resource<FirebaseUser>
    fun logout()

}