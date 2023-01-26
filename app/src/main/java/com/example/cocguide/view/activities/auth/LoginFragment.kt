package com.example.cocguide.view.activities.auth


import com.example.cocguide.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.cocguide.databinding.FragmentLoginBinding
import com.example.cocguide.model.network.Resource
import com.example.cocguide.view.activities.HomeOptionsActivity
import com.example.cocguide.viewmodel.AuthViewModel
import com.google.firebase.auth.FirebaseUser


class LoginFragment : Fragment(R.layout.fragment_login), View.OnClickListener {

    private lateinit var mBinding: FragmentLoginBinding
    private val authViewModel: AuthViewModel by activityViewModels()
    private val loginFlow = authViewModel.loginFLow
    private var email : String? = null
    private var password : String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentLoginBinding.inflate(layoutInflater, container, false)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        authViewModel = ViewModelProvider(this)[AuthViewModel::class.java]
        email = mBinding.etEmail.text.toString()
        password = mBinding.etPassword.text.toString()

        //TODO: for testing directly moving to home screen
//        val intent = Intent(this@LoginActivity, HomeOptionsActivity::class.java)
//        startActivity(intent)




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
//                mBinding.btnLogin.id -> {
//                    authViewModel.login(email, password)
//                    loginFlow.value.let {
//                        when(it)
//                        {
//                            Resource.success(it) -> {
//                                val intent = Intent(context, HomeOptionsActivity::class.java)
//                                startActivity(intent)
//                            }
//                            Resource.loading(it) -> {
//
//                            }
//                            Resource.error("Error Occurred", null) -> {
//                                Toast.makeText(context, "Error Occurred. Check network connection", Toast.LENGTH_SHORT).show()
//                            }
//                        }
//                    }
//
//
//                }

                mBinding.btnSignup.id -> {
                    Toast.makeText(context, "asdf", Toast.LENGTH_SHORT).show()
                    val fragmentManager = requireActivity().supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    val signUpFragment = SignUpFragment()
                    fragmentTransaction.replace(R.id.authFragmentContainer, signUpFragment)
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
            }
        }
    }

}