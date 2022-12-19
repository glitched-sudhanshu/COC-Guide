package com.example.cocguide.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.cocguide.R
import com.example.cocguide.databinding.FragmentClansBinding

class ClansFragment : Fragment(R.layout.fragment_clans) {

    private lateinit var mBinding : FragmentClansBinding

    override fun onResume() {
        super.onResume()
        val clanOptions = resources.getStringArray(R.array.clan_options)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, clanOptions)
        mBinding.autoCompleteTextView.setAdapter(arrayAdapter)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentClansBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}