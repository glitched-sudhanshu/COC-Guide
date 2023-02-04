package com.example.cocguide.view.fragments.services.players

import android.app.ActionBar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cocguide.R
import com.example.cocguide.databinding.FragmentClansBinding
import com.example.cocguide.databinding.FragmentPlayersBinding
import com.example.cocguide.databinding.FragmentVerifyPlayerBinding
import com.example.cocguide.view.adapter.PlayersVpAdapter
import com.google.android.material.tabs.TabLayoutMediator

class PlayersFragment : Fragment(R.layout.fragment_players) {

    private lateinit var mBinding: FragmentPlayersBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentPlayersBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout = mBinding.tlPlayersOptions
        val viewPager = mBinding.vpPlayersOptions

        val adapter = PlayersVpAdapter(this)
        viewPager.adapter = adapter

        val tabLayoutTexts = listOf("Player Information", "Verify Player")

        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            tab.text = tabLayoutTexts[position]
        }.attach()

    }

}