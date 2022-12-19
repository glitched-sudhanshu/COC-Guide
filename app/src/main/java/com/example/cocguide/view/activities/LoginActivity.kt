package com.example.cocguide.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cocguide.R
import com.example.cocguide.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var mBinding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityLoginBinding.inflate(layoutInflater)

//        val intent = Intent(this@LoginActivity, HomeOptionsActivity::class.java)
//        startActivity(intent)

        setContentView(mBinding.root)

        onClickListeners()
    }

    private fun onClickListeners() {
        mBinding.btnLogin.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if(view != null){
            when(view.id)
            {
                R.id.btnLogin -> {
                    val intent = Intent(this@LoginActivity, HomeOptionsActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}