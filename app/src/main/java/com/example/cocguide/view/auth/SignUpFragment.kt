package com.example.cocguide.view.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cocguide.R
import com.example.cocguide.databinding.FragmentSignUpBinding
import com.example.cocguide.view.activities.serviceOptions.HomeOptionsActivity

class SignUpFragment : Fragment(R.layout.fragment_sign_up), View.OnClickListener {

    private lateinit var mBinding: FragmentSignUpBinding
    private var username : String? = null
    private var email : String? = null
    private var password : String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding = FragmentSignUpBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        username = mBinding.etUsername.text.toString()
        email = mBinding.etEmail.text.toString()
        password = mBinding.etPassword.text.toString()

        onClickListeners()
    }

    private fun onClickListeners() {
        mBinding.btnSignup.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if(view != null){
            when(view.id)
            {
                mBinding.btnSignup.id -> {
                    val intent = Intent(requireContext(), HomeOptionsActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

}