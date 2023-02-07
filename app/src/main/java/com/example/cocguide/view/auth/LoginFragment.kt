package com.example.cocguide.view.auth


import android.content.Intent
import com.example.cocguide.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cocguide.databinding.FragmentLoginBinding
import com.example.cocguide.view.activities.serviceOptions.HomeOptionsActivity


class LoginFragment : Fragment(R.layout.fragment_login), View.OnClickListener {

    private lateinit var mBinding: FragmentLoginBinding
    private var email : String? = null
    private var password : String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding = FragmentLoginBinding.inflate(layoutInflater, container, false)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        email = mBinding.etEmail.text.toString()
        password = mBinding.etPassword.text.toString()

        onClickListeners()
    }

    private fun onClickListeners() {
        mBinding.btnLogin.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if(view != null){
            when(view.id)
            {
                mBinding.btnLogin.id -> {
                    val intent = Intent(requireContext(), HomeOptionsActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

}