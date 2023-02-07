package com.example.cocguide.view.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.cocguide.databinding.ActivityAuthBinding
import com.example.cocguide.view.adapter.AuthVpAdapter
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

        val fragmentManager = supportFragmentManager
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

        mBinding.loginViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                val progress = (position + positionOffset) / (adapter.itemCount - 1)
                mBinding.mlCons.progress = progress
            }
        })


//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
//        navController = navHostFragment.navController
//
//        setupActionBarWithNavController(navController)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }
}