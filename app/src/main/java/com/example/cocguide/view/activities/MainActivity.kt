package com.example.cocguide.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.cocguide.R
import com.example.cocguide.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(mBinding.root)

//        mBinding.button.setBackgroundResource(R.drawable.button_bg)

//        val intent = Intent(this@MainActivity, HomeOptionsActivity::class.java)
//         startActivity(intent)
    }
}