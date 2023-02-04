package com.example.cocguide.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cocguide.R
import com.example.cocguide.databinding.ActivityHomeOptionsBinding
import com.example.cocguide.view.adapter.HomeScreenOptionsAdapter

class HomeOptionsActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityHomeOptionsBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityHomeOptionsBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        homeOptionsList()

    }

    private fun homeOptionsList() {
        val optionsList = listOf("Clans", "Players", "League", "Ranking", "Esports", "Goldpass")
        val imageList = listOf(R.drawable.clan_image, R.drawable.player_image, R.drawable.league_image, R.drawable.rating_image,R.drawable.esports_image, R.drawable.goldpass_image)

        val homeScreenOptionsAdapter = HomeScreenOptionsAdapter(optionsList, imageList, this)
        mBinding.homeScreenOptionsRv.layoutManager = GridLayoutManager(this, 2)
        mBinding.homeScreenOptionsRv.adapter = homeScreenOptionsAdapter
    }
}