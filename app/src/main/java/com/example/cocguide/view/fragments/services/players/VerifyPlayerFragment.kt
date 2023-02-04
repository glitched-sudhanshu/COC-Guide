package com.example.cocguide.view.fragments.services.players

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cocguide.R
import com.example.cocguide.databinding.FragmentVerifyPlayerBinding


class VerifyPlayerFragment : Fragment(R.layout.fragment_verify_player) {

    private lateinit var mBinding : FragmentVerifyPlayerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentVerifyPlayerBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

}