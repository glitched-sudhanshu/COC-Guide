package com.example.cocguide.view.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.cocguide.R
import com.example.cocguide.databinding.FragmentFirstScreenBinding
import com.example.cocguide.databinding.FragmentSecondScreenBinding

class SecondScreenFragment : Fragment() {


    private var mBinding: FragmentSecondScreenBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding = FragmentSecondScreenBinding.inflate(layoutInflater, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val viewPager = activity?.findViewById<ViewPager2>(R.id.onBoardingVp)
        mBinding!!.fabNext2.setOnClickListener{
            viewPager?.currentItem = 2
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}