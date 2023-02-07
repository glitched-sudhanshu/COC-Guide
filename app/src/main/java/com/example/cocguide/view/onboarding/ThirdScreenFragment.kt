package com.example.cocguide.view.onboarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.cocguide.R
import com.example.cocguide.databinding.FragmentFirstScreenBinding
import com.example.cocguide.databinding.FragmentSecondScreenBinding
import com.example.cocguide.databinding.FragmentThirdScreenBinding
import com.example.cocguide.model.utils.Constants.ON_BOARDING_FINISHED
import com.example.cocguide.model.utils.Constants.ON_BOARDING_FINISHED_KEY

class ThirdScreenFragment : Fragment() {


    private var mBinding: FragmentThirdScreenBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding = FragmentThirdScreenBinding.inflate(layoutInflater, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        mBinding!!.finish.setOnClickListener {
            super.onViewCreated(view, savedInstanceState)
            onBoardingFinished()
            findNavController().navigate(R.id.action_onBoardingVpFragment_to_authActivity)
        }
    }

    private fun onBoardingFinished() {
        val sharedPref =
            requireActivity().getSharedPreferences(ON_BOARDING_FINISHED, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean(ON_BOARDING_FINISHED_KEY, true)
        editor.apply()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}