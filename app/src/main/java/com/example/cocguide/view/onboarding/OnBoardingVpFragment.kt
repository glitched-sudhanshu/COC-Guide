package com.example.cocguide.view.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cocguide.databinding.FragmentOnBoardingVpBinding
import com.example.cocguide.view.adapter.OnBoardingVpAdapter

class OnBoardingVpFragment : Fragment() {

    private var mBinding: FragmentOnBoardingVpBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding = FragmentOnBoardingVpBinding.inflate(layoutInflater, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreenFragment(),
            SecondScreenFragment(),
            ThirdScreenFragment()
        )

        val adapter = OnBoardingVpAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)

        mBinding!!.onBoardingVp.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}