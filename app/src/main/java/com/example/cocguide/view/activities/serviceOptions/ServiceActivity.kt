package com.example.cocguide.view.activities.serviceOptions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cocguide.R
import com.example.cocguide.databinding.ActivityServiceBinding
import com.example.cocguide.model.utils.Constants.FRAGMENT_INDEX
import com.example.cocguide.view.fragments.services.*
import com.example.cocguide.view.fragments.services.players.PlayersFragment

class ServiceActivity : AppCompatActivity() {

    private lateinit var mBinding :ActivityServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        //todo use safeargs
        val fragmentIndex = intent.getIntExtra(FRAGMENT_INDEX, 0)

        val clansFragment = ClansFragment()
        val esportsFragment = EsportsFragment()
        val goldPassFragment = GoldPassFragment()
        val leagueFragment = LeagueFragment()
        val playersFragment = PlayersFragment()
        val rankingFragment = RankingFragment()

        val listOfFragment = listOf(clansFragment, playersFragment, leagueFragment, rankingFragment, esportsFragment, goldPassFragment)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container_view, listOfFragment[fragmentIndex])
            commit()
        }

    }
}