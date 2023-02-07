package com.example.cocguide.view.onboarding

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.cocguide.R
import com.example.cocguide.databinding.FragmentSplashBinding
import com.example.cocguide.model.utils.Constants.ON_BOARDING_FINISHED
import com.example.cocguide.model.utils.Constants.ON_BOARDING_FINISHED_KEY


class SplashFragment : Fragment() {

    private var mBinding : FragmentSplashBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            if(onBoardingFinished())
            {
//                findNavController().navigate(R.id.action_splashFragment_to_authActivity)
                findNavController().navigate(R.id.action_splashFragment_to_onBoardingVpFragment)
            }else{
                findNavController().navigate(R.id.action_splashFragment_to_onBoardingVpFragment)
            }

        }, 2000)
    }

    private fun onBoardingFinished() : Boolean{
        val sharedPref = requireActivity().getSharedPreferences(ON_BOARDING_FINISHED, Context.MODE_PRIVATE)
        return sharedPref.getBoolean(ON_BOARDING_FINISHED_KEY, false)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}