package com.example.cocguide.view.onboarding

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import com.example.cocguide.R
import com.example.cocguide.databinding.FragmentFirstScreenBinding

class FirstScreenFragment : Fragment() {

    private var mBinding: FragmentFirstScreenBinding? = null
//    private var navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        sharedElementReturnTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding = FragmentFirstScreenBinding.inflate(layoutInflater, container, false)
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding!!.fabNext1.setOnClickListener{
            val extras = FragmentNavigator.Extras.Builder()
                .addSharedElement(mBinding!!.img, "transitImage")
                .addSharedElement(mBinding!!.txt1, "transitText1")
                .addSharedElement(mBinding!!.txt2, "transitText2")
                .addSharedElement(mBinding!!.txt3, "transitText3")
                .build()
            findNavController().navigate(R.id.action_firstScreenFragment_to_secondScreenFragment, null, null, extras)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}