package com.example.cocguide.view.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cocguide.view.serviceOptions.services.players.VerifyPlayerFragment
import com.example.cocguide.view.serviceOptions.services.players.PlayerInfoFragment

class PlayersVpAdapter(
    val fragment : Fragment
) : FragmentStateAdapter(fragment){

    override fun createFragment(position: Int): Fragment {
        val playerInfoFragment = PlayerInfoFragment()
        val verifyPlayerFragment = VerifyPlayerFragment()
        val listFragments = listOf(playerInfoFragment, verifyPlayerFragment)
        return listFragments[position]
    }

    override fun getItemCount(): Int {
        return 2
    }
}