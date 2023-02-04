package com.example.cocguide.view.fragments.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.cocguide.R
import com.example.cocguide.databinding.FragmentRankingBinding


class RankingFragment : Fragment(R.layout.fragment_ranking) {
    private lateinit var mBinding: FragmentRankingBinding

    override fun onResume() {
        super.onResume()
        val rankOptions = resources.getStringArray(R.array.rank_options)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, rankOptions)
        mBinding.autoCompleteTextView.setAdapter(arrayAdapter)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding = FragmentRankingBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.autoCompleteTextView.setOnItemClickListener { parent, _, position, _ ->
            val selectedResult = parent!!.getItemAtPosition(position).toString()
            if (selectedResult == "List Locations") {
                mBinding.tilLocationId.visibility = View.GONE
            } else mBinding.tilLocationId.visibility = View.VISIBLE
        }

    }

}