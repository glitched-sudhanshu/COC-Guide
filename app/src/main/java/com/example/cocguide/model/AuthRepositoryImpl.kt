package com.example.cocguide.model

import com.example.cocguide.model.network.Resource
import com.example.cocguide.model.utils.await
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest

class AuthRepositoryImpl(
    private val firebaseAuth : FirebaseAuth
) : AuthRepository {


    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun login(email: String, password: String): Resource<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Resource.success(result.user!!)
        }catch (e : Exception)
        {
            e.printStackTrace()
            Resource.error(e.message.toString(), null)

        }
    }

    override suspend fun signup(
        name: String,
        email: String,
        password: String,
    ): Resource<FirebaseUser> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            result?.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(name).build())?.await()
            Resource.success(result.user!!)
        }catch (e : Exception)
        {
            e.printStackTrace()
            Resource.error(e.message.toString(), null)
        }
    }

    override fun logout() {
        firebaseAuth.signOut()
    }
}