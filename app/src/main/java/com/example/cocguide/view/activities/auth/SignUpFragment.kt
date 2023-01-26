package com.example.cocguide.view.activities.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navGraphViewModels
import com.example.cocguide.R
import com.example.cocguide.databinding.FragmentClansBinding
import com.example.cocguide.databinding.FragmentLoginBinding
import com.example.cocguide.databinding.FragmentSignUpBinding
import com.example.cocguide.model.network.Resource
import com.example.cocguide.view.activities.HomeOptionsActivity
import com.example.cocguide.viewmodel.AuthViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest

class SignUpFragment : Fragment(R.layout.fragment_sign_up), View.OnClickListener {

    private lateinit var mBinding: FragmentSignUpBinding
    private var authViewModel by activityViewModels<AuthViewModel>()



//    private val signupFlow = authViewModel.signupFlow
    private var username : String? = null
    private var email : String? = null
    private var password : String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
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
        mBinding.btnLogin.setOnClickListener(this)
        mBinding.btnSignup.setOnClickListener(this)
    }
    override fun onClick(view: View?) {
        if(view != null){
            when(view.id)
            {
                mBinding.btnLogin.id -> {
                    Toast.makeText(context, "asdf", Toast.LENGTH_SHORT).show()
                    val fragmentManager = requireActivity().supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    val loginFragment = LoginFragment()
                    fragmentTransaction.replace(R.id.authFragmentContainer, loginFragment)
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }

                mBinding.btnSignup.id -> {
                    authViewModel.signup(name = username, email = email, password = password)
                    authViewModel.signupFlow.value.let {
                        when(it)
                        {
                            Resource.success(it) -> {
                                val intent = Intent(context, HomeOptionsActivity::class.java)
                                startActivity(intent)
                            }
                            Resource.loading(it) -> {

                            }
                            Resource.error("Error Occurred", null) -> {
                                Toast.makeText(context, "Error Occurred. Check network connection", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }
        }
    }

}