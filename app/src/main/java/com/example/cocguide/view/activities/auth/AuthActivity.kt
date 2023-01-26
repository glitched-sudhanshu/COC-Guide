package com.example.cocguide.view.activities.auth

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cocguide.R
import com.example.cocguide.viewmodel.AuthViewModel


class AuthActivity : AppCompatActivity() {

    private val authViewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val signUpFragment = SignUpFragment()
        fragmentTransaction.replace(R.id.authFragmentContainer, signUpFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}