package com.example.cocguide.view.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.example.cocguide.R
import com.example.cocguide.databinding.ActivitySplashScreenBinding
import com.example.cocguide.databinding.FragmentFirstScreenBinding
import com.example.cocguide.databinding.FragmentSplashBinding
import com.example.cocguide.view.startAnimation

class FirstScreenFragment : Fragment() {

    private var mBinding: FragmentFirstScreenBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding = FragmentFirstScreenBinding.inflate(layoutInflater, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.anim_circle_explosion).apply {
            duration = 700
            interpolator = AccelerateDecelerateInterpolator()
        }

        val viewPager = activity?.findViewById<ViewPager2>(R.id.onBoardingVp)
        mBinding!!.fabNext1.setOnClickListener{
            mBinding!!.fabNext1.isVisible = false
            mBinding!!.view.isVisible = true
            mBinding!!.view.startAnimation(animation){
                viewPager?.currentItem = 1
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}