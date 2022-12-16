package com.example.cocguide.view.activities

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cocguide.R
import com.example.cocguide.databinding.ActivityHomeOptionsBinding
import com.example.cocguide.view.adapter.HomeScreenOptionsAdapter

class HomeOptionsActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityHomeOptionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityHomeOptionsBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val optionsList = listOf("Clans", "Players", "League", "Locations", "Esports", "Goldpass")
        val imageList = listOf(R.drawable.clan_image, R.drawable.player_image, R.drawable.league_image, R.drawable.location_image, R.drawable.esports_image, R.drawable.goldpass_image)

        val homeScreenOptionsAdapter = HomeScreenOptionsAdapter(optionsList, imageList, this)
        mBinding.homeScreenOptionsRv.layoutManager = GridLayoutManager(this, 2)
        mBinding.homeScreenOptionsRv.adapter = homeScreenOptionsAdapter
    }
}