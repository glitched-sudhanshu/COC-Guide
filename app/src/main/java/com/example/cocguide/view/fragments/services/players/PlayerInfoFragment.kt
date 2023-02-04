package com.example.cocguide.view.fragments.services.players

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cocguide.R
import com.example.cocguide.databinding.FragmentClansBinding
import com.example.cocguide.databinding.FragmentPlayerInfoBinding

class PlayerInfoFragment : Fragment(R.layout.fragment_player_info) {

    private lateinit var mBinding : FragmentPlayerInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentPlayerInfoBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

}