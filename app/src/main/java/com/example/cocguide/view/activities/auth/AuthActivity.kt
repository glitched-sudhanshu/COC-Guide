package com.example.cocguide.view.activities.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.cocguide.R
import com.example.cocguide.databinding.ActivityAuthBinding
import com.example.cocguide.view.adapter.AuthVpAdapter
import com.example.cocguide.view.adapter.PlayersVpAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class AuthActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityAuthBinding
//    private lateinit var navController: NavController
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityAuthBinding.inflate(layoutInflater)

        setContentView(mBinding.root)

        tabLayout = mBinding.tabLayout
        viewPager = mBinding.loginViewPager

        val fragmentManager = supportFragmentManager;
        val adapter = AuthVpAdapter(fragmentManager, lifecycle)
//
//        val adapter = PlayersVpAdapter(this)
        viewPager.adapter = adapter
//
        val tabLayoutTexts = listOf("Login", "Signup")
//
        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            tab.text = tabLayoutTexts[position]
        }.attach()
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL


//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
//        navController = navHostFragment.navController
//
//        setupActionBarWithNavController(navController)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }
}