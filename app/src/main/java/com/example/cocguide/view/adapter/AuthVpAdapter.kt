package com.example.cocguide.view.adapter

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cocguide.view.activities.auth.LoginFragment
import com.example.cocguide.view.activities.auth.SignUpFragment
import com.example.cocguide.view.fragments.services.players.PlayerInfoFragment
import com.example.cocguide.view.fragments.services.players.VerifyPlayerFragment

class AuthVpAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {



    override fun createFragment(position: Int): Fragment {
        val loginFragment = LoginFragment()

        val signUpFragment = SignUpFragment()
        if(position == 1){
            return signUpFragment
        }
        return loginFragment
//        val loginFragment = LoginFragment()
//        val signUpFragment = SignUpFragment()
//        val listFragments = listOf(loginFragment, signUpFragment)
//        return listFragments[position]
    }

    override fun getItemCount(): Int {
        return 2
    }
}