package com.example.cocguide.view.fragments.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.cocguide.R
import com.example.cocguide.databinding.FragmentLeagueBinding

class LeagueFragment : Fragment(R.layout.fragment_league) {
    private lateinit var mBinding: FragmentLeagueBinding

    override fun onResume() {
        super.onResume()
        val leagueOptions = resources.getStringArray(R.array.league_options)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, leagueOptions)
        mBinding.autoCompleteTextView.setAdapter(arrayAdapter)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding = FragmentLeagueBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.autoCompleteTextView.setOnItemClickListener { parent, _, position, _ ->
            val selectedResult = parent!!.getItemAtPosition(position).toString()

            if(selectedResult == "List Capital Leagues" || selectedResult == "List Leagues" || selectedResult == "War Leagues"){
                mBinding.tilLeagueId.visibility = View.GONE
            }else mBinding.tilLeagueId.visibility = View.VISIBLE

            if(selectedResult == "League Season Ranking"){
                mBinding.tilSeasonId.visibility = View.VISIBLE
            }else mBinding.tilSeasonId.visibility = View.GONE

        }

    }

}